package cn.ccf.forum.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ccf.forum.mapper.ThreadMapper;
import cn.ccf.forum.model.Board;
import cn.ccf.forum.model.MyPostThread;
import cn.ccf.forum.model.Person;
import cn.ccf.forum.model.Reply;
import cn.ccf.forum.model.Thread;
import net.sf.json.JSONArray;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import cn.ccf.forum.util.Pagination;
import cn.ccf.forum.util.PersonInfo;
import cn.ccf.forum.util.PersonUtil;
import cn.ccf.forum.Service.BoardService;
import cn.ccf.forum.Service.ReplyService;
import cn.ccf.forum.Service.ThreadService;

@Controller
public class ThreadController {

	@Autowired
	private ThreadService threadService;
	
	@Autowired
	private ThreadMapper threadMapper;
	
	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("thread_list.do")
	public ModelAndView list( HttpServletRequest request, HttpServletResponse response){
		return view(request,response);
	}
	
	@RequestMapping("thread_view.do")
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response){
		Thread thread =threadService.selectThreadContent(Integer.parseInt(request.getParameter("id")));
		Pagination pagination = new Pagination(request, response);
		pagination.setRecordCount(thread.getReplycount());
		List<Reply> replyList = replyService.list(thread.getId(), new RowBounds(pagination.getFirstResult(), pagination.getPageSize()));
		threadService.updateHit(thread.getId());
		request.setAttribute("thread", thread);
		request.setAttribute("pagination", pagination);
		request.setAttribute("replyList", replyList);
		request.setAttribute("title", "浏览帖子 - 标题：" + thread.getTitle());
		return new ModelAndView("forum/thread/viewThread");
	}
	
	@RequestMapping("thread_initAdd.do")
	public ModelAndView initAdd(HttpServletRequest request){
		Board board =boardService.selectBoardById(Integer.parseInt(request.getParameter("id")));
		Thread thread=new Thread();
		thread.setBoardId(board.getId());
		request.setAttribute("board", board);
		request.setAttribute("title", "发表帖子 - 版面：" + board.getName());
		request.setAttribute("thread", thread);
		return new ModelAndView("forum/thread/addThread");
	}
	
	@RequestMapping("thread_add.do")
	public String add(@ModelAttribute Thread thread, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		if (thread.getContent().trim() == "") {
			boolean flag = true;
			request.setAttribute("flag", flag);
			return "forward:thread_initAdd.do?action=initAdd&id="+thread.getBoardId();
		} else {
			PersonInfo personInfo = PersonUtil.getPersonInfo(request, response);
			thread.setAuthorId(personInfo.getId());
			thread.setAuthorLastReplied(null);
			thread.setDatecreated(new Date());
			thread.setDatelastreplied(new Date());
			thread.setDeleted(false);
			thread.setIpcreated(request.getRemoteAddr());
			thread.setReadonly(false);
			thread.setReplycount(0);
			thread.setTopped(false);
			thread.setHit(0);
			threadService.save(thread);
			boardService.updateBoard(thread.getBoardId(), threadService.selectCurrentThread(thread.getTitle()));
		}
		return "redirect:board_list.do?id="+thread.getBoardId();
	}
	
	@RequestMapping(value="getMyPostThread.do", method = RequestMethod.POST)
	@ResponseBody
	public List<MyPostThread> getMyPostThread(HttpServletRequest req) {
		
		int id = ((PersonInfo)req.getSession().getAttribute("personInfo")).getId();
		
		List<Thread> thread = threadMapper.getByAuthorId(id);
		
		List<MyPostThread> list = new ArrayList<MyPostThread>();
		
		for (Iterator iterator = thread.iterator(); iterator.hasNext();) {
			Thread myThread = (Thread) iterator.next();
			MyPostThread tempThread = new MyPostThread();
			tempThread.setId(myThread.getId());
			tempThread.setTitle(myThread.getTitle());
			tempThread.setHit(myThread.getHit());
			tempThread.setReplycount(myThread.getReplycount());
			Date date = myThread.getDatecreated();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			tempThread.setDatecreated(dateFormat.format(date));
			list.add(tempThread);
			
		}
		
		
		return list;
	}
}
