package cn.ccf.forum.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import cn.ccf.forum.model.MyReply;
import cn.ccf.forum.model.Reply;

public interface ReplyMapper {
	
	
	
	List<Reply> getReplyByThreadID(Integer id);
	
	List<Reply> list(Integer id, RowBounds rowbounds);
	
	int selectReplyCount(Integer id);
	
	List<MyReply> getByAuthorId(int author_id);
	
	void deleteReply(Integer id);
	
	/*����Ϊ�Լ�ʵ�ֵķ�������������������õ��ķ���*/

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);
    
    
}