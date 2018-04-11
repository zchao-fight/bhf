package cn.ccf.mapper;

import cn.ccf.pojo.Preplan;
import cn.ccf.pojo.PreplanExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PreplanMapper {
    int countByExample(PreplanExample example);

    int deleteByExample(PreplanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Preplan record);

    int insertSelective(Preplan record);

    List<Preplan> selectByExample(PreplanExample example);

    Preplan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Preplan record, @Param("example") PreplanExample example);

    int updateByExample(@Param("record") Preplan record, @Param("example") PreplanExample example);

    int updateByPrimaryKeySelective(Preplan record);

    int updateByPrimaryKey(Preplan record);
}