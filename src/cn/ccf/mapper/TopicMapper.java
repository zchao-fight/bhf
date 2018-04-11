package cn.ccf.mapper;

import java.util.List;

import cn.ccf.pojo.Topic;
import cn.ccf.pojo.TopicExample;
import cn.ccf.pojo.TopicVO;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Topic record);

    int insertSelective(Topic record);

    List<Topic> selectByExampleWithBLOBs(TopicExample example);

    List<Topic> selectByExample(TopicExample example);
    
    List<TopicVO> selectTopic();

    Topic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKeyWithBLOBs(Topic record);

    int updateByPrimaryKey(Topic record);
}