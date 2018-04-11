package cn.ccf.mapper;

import cn.ccf.pojo.YZTCamera;
import cn.ccf.pojo.YZTCameraExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface YZTCameraMapper {
    int countByExample(YZTCameraExample example);

    int deleteByExample(YZTCameraExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(YZTCamera record);

    int insertSelective(YZTCamera record);

    List<YZTCamera> selectByExample(YZTCameraExample example);

    YZTCamera selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") YZTCamera record, @Param("example") YZTCameraExample example);

    int updateByExample(@Param("record") YZTCamera record, @Param("example") YZTCameraExample example);

    int updateByPrimaryKeySelective(YZTCamera record);

    int updateByPrimaryKey(YZTCamera record);
}