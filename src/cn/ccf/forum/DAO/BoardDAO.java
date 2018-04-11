package cn.ccf.forum.DAO;

import cn.ccf.forum.model.Board;

public interface BoardDAO {

	public Board selectBoardById(int id);
	public int creat(Board board);
	
	public int updateBoard(int boardId, int threadId);
	
	public int updateReplyCount(int id);
}
