package cn.ccf.forum.Controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ccf.forum.mapper.CategoryMapper;
import cn.ccf.forum.mapper.ThreadMapper;
import cn.ccf.forum.model.Board;
import cn.ccf.forum.model.Category;
import cn.ccf.forum.model.Person;
import cn.ccf.forum.model.Thread;

import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import cn.ccf.forum.util.Pagination;
import cn.ccf.forum.Service.BoardService;
import cn.ccf.forum.Service.CategoryService;
import cn.ccf.forum.Service.PersonService;
import cn.ccf.forum.Service.ThreadService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	@Autowired
	private ThreadService threadService;
	@Autowired
	private PersonService personService;
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Autowired ThreadMapper threadMapper;
	
	@RequestMapping("board_list.do")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response){
		
		
		Board board =boardService.selectBoardById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("title", "帖子列表 - 版面：" + board.getName());
		int totalCount=threadService.getCountByBoardId(board.getId());
		Pagination pagination = new Pagination(request, response);
		pagination.setRecordCount(totalCount);
		List<Thread> threadList = threadService.list(board.getId(),
				new RowBounds(pagination.getFirstResult(), pagination.getPageSize()));
		request.setAttribute("board", board);
		request.setAttribute("pagination", pagination);
		request.setAttribute("threadList", threadList);
		
		return new ModelAndView("forum/thread/listThread");
	}
	
	
	@RequestMapping("searchThread.do")
	public String searchThread(HttpServletRequest request, HttpServletResponse response, String keyword) {
		
		List<Thread> searchList = threadMapper.searchList(keyword);
		
		Boolean flag = CollectionUtils.isEmpty(searchList);
		request.setAttribute("keyword", keyword);
		request.setAttribute("flag", flag);
		request.setAttribute("threadList", searchList);
		
		return "forum/thread/searchThread";
		
	}
	
	@RequestMapping("board_initSetAdmin.do")
	public ModelAndView initSetAdmin(HttpServletRequest request){
		Board board =boardService.selectBoardById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("title", "设置管理员 - 版面：" + board.getName());
		List<Person> personList = personService.selectAll();
		int[] adminId = new int[board.getAdministrators().size()];
		int i = 0;
		for (Iterator<Person> it = board.getAdministrators().iterator(); it.hasNext(); i++) {
			Person p = it.next();
			adminId[i] = p.getId();
		}
		board.setAdminId(adminId);
		request.setAttribute("board", board);
		request.setAttribute("personList", personList);
		return new ModelAndView("forum/board/setAdmin");
	}
	
	@RequestMapping("board_setAdmin.do")
	public ModelAndView setAdmin(@ModelAttribute Board board, HttpServletRequest request){
		int boardId=Integer.parseInt(request.getParameter("id"));
		Board board1 =boardService.selectBoardById(boardId);
		personService.deleteByBoardId(board1.getId());
		request.setAttribute("title", "设置管理员 - 版面：" + board1.getName());
		int[] adminId =board.getAdminId();
		for (int i = 0; adminId != null && i < adminId.length; i++)
			personService.insertBoardAdministrator(board1.getId(), adminId[i]);
		return new ModelAndView("forum/board/success");
	}
	
	@RequestMapping("board_initAdd.do")
	public ModelAndView initAdd(HttpServletRequest request, Integer id){
		request.setAttribute("title", "添加版面");
		List<Category> categoryList =categoryService.getAll();
		Category category = categoryMapper.selectByPrimaryKey(id);
		request.setAttribute("category", category);
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("board", new Board());
		return new ModelAndView("forum/board/addBoard");
	}
	
	/*@RequestMapping("board_add.do")
	public ModelAndView add(@ModelAttribute Board board, HttpServletRequest request){
		request.setAttribute("title", "添加版面");
		board.setDatecreated(new Date());
		board.setDeleted(false);
		board.setReplycount(0);
		board.setThreadcount(0);
		boardService.creat(board);
		return new ModelAndView("forum/board/success");
	}*/
	
	@RequestMapping("board_add.do")
	@ResponseBody
	public JSONObject add(@ModelAttribute @RequestBody Board board, HttpServletRequest request){
		request.setAttribute("title", "添加版面");
		JSONObject json = new JSONObject();
		if (board.getName() == "") {
			json.put("res", 0);
			return json;
		}
		board.setDatecreated(new Date());
		board.setDeleted(false);
		board.setReplycount(0);
		board.setThreadcount(0);
		boardService.creat(board);
		
		json.put("res", 1);
		return json;
	}
	
}
