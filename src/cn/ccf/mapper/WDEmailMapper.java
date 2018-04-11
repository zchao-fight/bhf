package cn.ccf.mapper;

import cn.ccf.pojo.WDEmail;
import cn.ccf.pojo.WDEmailExample;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WDEmailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WDEmail record);

    int insertSelective(WDEmail record);

    List<WDEmail> selectByExample(WDEmailExample example);

    WDEmail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WDEmail record);

    int updateByPrimaryKey(WDEmail record);
}