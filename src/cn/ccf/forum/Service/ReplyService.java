package cn.ccf.forum.Service;

import java.util.List;

import cn.ccf.forum.model.Reply;

import org.apache.ibatis.session.RowBounds;

public interface ReplyService {

	public List<Reply> list(int id, RowBounds rowbounds);
	
	public int create(Reply reply);
	
	public int selectReplyCount(int id);
}
