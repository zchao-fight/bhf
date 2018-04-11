package cn.ccf.forum.ServiceImpl;

import java.util.Date;
import java.util.List;

import cn.ccf.forum.model.Thread;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ccf.forum.DAO.BoardDAO;
import cn.ccf.forum.DAO.ThreadDAO;
import cn.ccf.forum.Service.ThreadService;

@Service
public class ThreadServiceImpl implements ThreadService{

	@Autowired
	private ThreadDAO threadDAO;

	@Override
	public int getCountByBoardId(int id) {
		return threadDAO.getCountByBoardId(id);
	}


	@Override
	public List<Thread> list(int id, RowBounds rowbounds) {
		return threadDAO.list(id, rowbounds);
	}


	@Override
	public Thread selectThreadContent(int id) {
		return threadDAO.selectThreadContent(id);
	}


	@Override
	public int save(Thread thread) {
		return threadDAO.save(thread);
	}


	@Override
	public int updateHit(int id) {
		return threadDAO.updateHit(id);
	}


	@Override
	public int selectCurrentThread(String title) {
		return threadDAO.selectCurrentThread(title);
	}


	@Override
	public Thread selectThreadById(int id) {
		return threadDAO.selectThreadById(id);
	}


	@Override
	public int updateThread(int id, int replyId, Date date) {
		return threadDAO.updateThread(id, replyId,date);
	}
}
