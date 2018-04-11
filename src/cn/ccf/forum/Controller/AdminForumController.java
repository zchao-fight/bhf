package cn.ccf.forum.Controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.border.Border;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import cn.ccf.forum.Service.CategoryService;
import cn.ccf.forum.mapper.BoardMapper;
import cn.ccf.forum.mapper.CategoryMapper;
import cn.ccf.forum.mapper.ReplyMapper;
import cn.ccf.forum.mapper.ThreadMapper;
import cn.ccf.forum.model.Board;
import cn.ccf.forum.model.Category;
import cn.ccf.forum.model.Reply;
import cn.ccf.forum.model.Thread;

@Controller
public class AdminForumController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private ThreadMapper threadMapper;
	@Autowired
	private ReplyMapper replyMapper;

	@RequestMapping("/admin/forum/catagory.do")
	public ModelAndView adminCatagory(HttpServletRequest request) {
		List<Category> categoryList = categoryService.getList();
		request.setAttribute("categoryList", categoryList);
		return new ModelAndView("forum/admin/catagory");
	}

	@RequestMapping("/admin/forum/deleteCatagory.do")
	@ResponseBody
	public JSONObject deleteCatagory(Integer id) {
		JSONObject result = new JSONObject();
		if (id == null) {
			result.put("succ", 1);
			return result;
		}

		Category selectByPrimaryKey = categoryMapper.selectByPrimaryKey(id);
		if (selectByPrimaryKey == null) {
			result.put("succ", 1);
			return result;
		}

		selectByPrimaryKey.setBoardList(null);
		selectByPrimaryKey.setDeleted(true);
		selectByPrimaryKey.setName(null);
		selectByPrimaryKey.setDatecreated(null);
		categoryMapper.updateByPrimaryKeySelective(selectByPrimaryKey);
		result.put("succ", 1);
		return result;
	}

	@RequestMapping("/admin/forum/board.do")
	public ModelAndView adminBoard(Integer catagoryId, HttpServletRequest request) {
		if (catagoryId == null) {
			request.setAttribute("catagory", null);
		} else {
			Category catagory = categoryMapper.selectByPrimaryKey(catagoryId);
			List<Board> findBoardByCategoryId = boardMapper.findBoardByCategoryId(catagoryId);
			request.setAttribute("number", findBoardByCategoryId.size());
			if (catagory != null) {
				catagory.setBoardList(findBoardByCategoryId);
			}
			request.setAttribute("catagory", catagory);
			request.setAttribute("catagoryId", catagoryId);
		}
		return new ModelAndView("forum/admin/board");
	}

	@RequestMapping("/admin/forum/deleteBoard.do")
	@ResponseBody
	public JSONObject deleteBoard(Integer id) {
		JSONObject result = new JSONObject();
		if (id == null) {
			result.put("succ", 1);
			return result;
		}

		Board selectByPrimaryKey = boardMapper.selectByPrimaryKey(id);
		if (selectByPrimaryKey == null) {
			result.put("succ", 1);
			return result;
		}

		Board update = new Board();
		update.setId(id);
		update.setDeleted(true);
		boardMapper.updateByPrimaryKeySelective(update);
		return result;
	}

	@RequestMapping("/admin/forum/threadSetTop.do")
	@ResponseBody
	public JSONObject threadSetTop(Integer id) {
		if (id != null) {
			threadMapper.updateTop(id, 1);
		}
		JSONObject result = new JSONObject();
		result.put("succ", 1);
		return result;
	}
	
	@RequestMapping("/admin/forum/threadCancelSetTop.do")
	@ResponseBody
	public JSONObject threadCancelSetTop(Integer id) {
		if (id != null) {
			threadMapper.updateTop(id, 0);
		}
		JSONObject result = new JSONObject();
		result.put("succ", 1);
		return result;
	}
	
	@RequestMapping("/admin/forum/deleteThread.do")
	@ResponseBody
	public JSONObject deleteThread(Integer id) {
		if (id != null) {
			threadMapper.deleteThread(id);
			Thread thread = threadMapper.selectByPrimaryKey(id);
			int boardId = thread.getBoardId();
			Board board = boardMapper.selectByPrimaryKey(boardId);
			
			int latestThreadId = threadMapper.selectlatestByBoardID(boardId);
			if (latestThreadId != 0) {
				board.setLastThreadId(latestThreadId);
			} else {
				board.setLastThreadId(null);
			}
			board.setThreadcount(board.getThreadcount()-1);
			List<Reply> replies = replyMapper.getReplyByThreadID(id);
			
			board.setReplycount(board.getReplycount()-replies.size());
			boardMapper.updateByPrimaryKeySelective(board);
			
			
			for (Iterator iterator = replies.iterator(); iterator.hasNext();) {
				Reply reply = (Reply) iterator.next();
				reply.setDeleted(true);
				replyMapper.updateByPrimaryKey(reply);
				
			}
			
			
		}
		JSONObject result = new JSONObject();
		result.put("succ", 1);
		return result;
	}
	
	@RequestMapping("/admin/forum/deleteReply.do")
	@ResponseBody
	public JSONObject deleteReply(Integer id) {
		if (id != null) {
			replyMapper.deleteReply(id);
			Reply reply = replyMapper.selectByPrimaryKey(id);
			Thread thread = threadMapper.selectByPrimaryKey(reply.getThreadId());
			threadMapper.updateReplyCount(reply.getThreadId());
			Board board = boardMapper.selectBoardById(thread.getBoardId());
			board.setReplycount(board.getReplycount()-1);
			boardMapper.updateByPrimaryKeySelective(board);
		}
		JSONObject result = new JSONObject();
		result.put("succ", 1);
		return result;
	}
}
