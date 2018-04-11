package cn.ccf.forum.DAOImpl;

import java.util.List;

import cn.ccf.forum.mapper.ReplyMapper;
import cn.ccf.forum.model.Reply;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.ccf.forum.DAO.ReplyDAO;

@Repository
public class ReplyDAOImpl implements ReplyDAO{

	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	public List<Reply> list(int id, RowBounds rowbounds) {
		return replyMapper.list(id, rowbounds);
	}

	@Override
	public int create(Reply reply) {
		return replyMapper.insertSelective(reply);
	}

	@Override
	public int selectReplyCount(int id) {
		return replyMapper.selectReplyCount(id);
	}

}
