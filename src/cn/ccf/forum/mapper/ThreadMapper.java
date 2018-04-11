package cn.ccf.forum.mapper;

import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.ccf.forum.model.Thread;

public interface ThreadMapper {
	
	int getCountByBoardId(Integer id);
	
	List<Thread> list(int id, RowBounds rowbounds);
	
	int selectlatestByBoardID(int boardId);
	
	int updateReplyCount(int id);
	
	List<Thread> searchList(String title);
	
	/**
	 * @author zc
	 * @param id
	 * @return
	 */
	List<Thread> getByAuthorId(int author_id);
	
	Thread selectThreadContent(Integer id);
	
    int updateHit(int id);
    
    int selectCurrentThread(String title);
    
    int updateThread(@Param("id") int id, @Param("replyId") int replyId, @Param("date") Date date);
    
    
    int updateTop(@Param("id") int id, @Param("topped") int topped);
    
    int deleteThread(@Param("id") int id);
    
    /*����Ϊ�Լ�ʵ�ֵķ�������������������õ��ķ���*/

    int insert(Thread record);

    int insertSelective(Thread record);

    Thread selectByPrimaryKey(Integer id);
    
    List<Thread> selectPortalThread();

}