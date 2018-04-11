package cn.ccf.mapper;

import cn.ccf.pojo.YZTEvent;
import cn.ccf.pojo.YZTEventExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface YZTEventMapper {
    int countByExample(YZTEventExample example);

    int deleteByExample(YZTEventExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(YZTEvent record);

    int insertSelective(YZTEvent record);

    List<YZTEvent> selectByExample(YZTEventExample example);

    YZTEvent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") YZTEvent record, @Param("example") YZTEventExample example);

    int updateByExample(@Param("record") YZTEvent record, @Param("example") YZTEventExample example);

    int updateByPrimaryKeySelective(YZTEvent record);

    int updateByPrimaryKey(YZTEvent record);
}