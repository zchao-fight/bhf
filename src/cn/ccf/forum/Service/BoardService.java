package cn.ccf.forum.Service;

import cn.ccf.forum.model.Board;

public interface BoardService {
	
	public Board selectBoardById(int id);
	
	public int creat(Board board);
	
	public int updateBoard(int boardId, int threadId);
	
	public int updateReplyCount(int id);

}
