package cn.ccf.forum.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ccf.forum.mapper.ReplyMapper;
import cn.ccf.forum.model.MyReply;
import cn.ccf.forum.model.Reply;
import cn.ccf.forum.model.Thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.ccf.forum.util.PersonInfo;
import cn.ccf.forum.util.PersonUtil;
import cn.ccf.forum.Service.BoardService;
import cn.ccf.forum.Service.ReplyService;
import cn.ccf.forum.Service.ThreadService;

@Controller
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	@Autowired
	private ThreadService threadService;
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@RequestMapping("reply_initAdd.do")
	public ModelAndView initAdd(HttpServletRequest request){
		Thread thread = threadService.selectThreadContent(Integer.parseInt(request.getParameter("id")));
		Reply reply=new Reply();
		reply.setTitle("Re:"+thread.getTitle());
		reply.setThreadId(thread.getId());
		request.setAttribute("title", "回复帖子 - 标题：" + thread.getTitle());
		request.setAttribute("thread", thread);
		request.setAttribute("reply", reply);
		return new ModelAndView("forum/reply/addReply");
	}
	 
	@RequestMapping("reply_add.do")
	public String add(@ModelAttribute Reply reply, HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		if (reply.getContent().trim() == "") {
			/*response.setContentType("text/html;charset=utf-8");//转码
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>;alert('请输入内容');</script>");*/
			boolean flag = true;
			request.setAttribute("flag", flag);
			return "forward:reply_initAdd.do?action=initAdd&id="+reply.getThreadId();
		} else {
			Thread thread=threadService.selectThreadById(reply.getThreadId());
			PersonInfo personInfo = PersonUtil.getPersonInfo(request, response);
			reply.setAuthorId(personInfo.getId());
			reply.setDatecreated(new Date());
			reply.setDeleted(false);
			reply.setFloor(replyService.selectReplyCount(thread.getId())+1);
			replyService.create(reply);
			threadService.updateThread(thread.getId(),personInfo.getId(),new Date());//更新帖子最后回复时间、回复人、回复数
			boardService.updateReplyCount(thread.getBoardId());//更新版面回复数
			request.setAttribute("thread", thread);
			request.setAttribute("title", "回复帖子 - 标题：" + thread.getTitle());
			boolean flag = false;
			request.setAttribute("flag", flag);
		}
		
		
		return "forum/reply/success";
	}
	
	@RequestMapping(value="getMyReplyThread.do", method = RequestMethod.POST)
	@ResponseBody
	public List<MyReply> getMyReplyThread(HttpServletRequest req) {
		
		int id = ((PersonInfo)req.getSession().getAttribute("personInfo")).getId();
		List<MyReply> list = replyMapper.getByAuthorId(id);
		return list;
	}
}
