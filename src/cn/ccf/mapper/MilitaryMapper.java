package cn.ccf.mapper;

import cn.ccf.pojo.Military;
import cn.ccf.pojo.MilitaryExample;
import cn.ccf.pojo.MilitaryWithBLOBs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MilitaryMapper {
    int countByExample(MilitaryExample example);

    int deleteByExample(MilitaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MilitaryWithBLOBs record);

    int insertSelective(MilitaryWithBLOBs record);

    List<MilitaryWithBLOBs> selectByExampleWithBLOBs(MilitaryExample example);

    List<Military> selectByExample(MilitaryExample example);

    MilitaryWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MilitaryWithBLOBs record, @Param("example") MilitaryExample example);

    int updateByExampleWithBLOBs(@Param("record") MilitaryWithBLOBs record, @Param("example") MilitaryExample example);

    int updateByExample(@Param("record") Military record, @Param("example") MilitaryExample example);

    int updateByPrimaryKeySelective(MilitaryWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MilitaryWithBLOBs record);

    int updateByPrimaryKey(Military record);
}