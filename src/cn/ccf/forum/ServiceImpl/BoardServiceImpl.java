package cn.ccf.forum.ServiceImpl;

import cn.ccf.forum.model.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ccf.forum.DAO.BoardDAO;
import cn.ccf.forum.Service.BoardService;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO boardDAO;

	@Override
	public Board selectBoardById(int id) {
		return boardDAO.selectBoardById(id);
	}

	@Override
	public int creat(Board board) {
		return boardDAO.creat(board);
	}

	@Override
	public int updateBoard(int boardId, int threadId) {
		return boardDAO.updateBoard(boardId, threadId);
	}

	@Override
	public int updateReplyCount(int id) {
		return boardDAO.updateReplyCount(id);
	}
}
