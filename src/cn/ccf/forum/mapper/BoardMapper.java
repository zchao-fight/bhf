package cn.ccf.forum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.ccf.forum.model.Board;

public interface BoardMapper {
	
	Board selectBoardById(Integer id);
	
	List<Board> findBoardByCategoryId(Integer categoryId);
	
	int updateBoard(@Param("boardId") int boardId, @Param("threadId") int threadId);
    
    int updateReplyCount(Integer id);
    
    /*����Ϊ�Լ�ʵ�ֵķ�������������������õ��ķ���*/

    int deleteByPrimaryKey(Integer id);

    int insert(Board record);

    int insertSelective(Board record);

    Board selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Board record);

    int updateByPrimaryKey(Board record);
}