package cn.ccf.mapper;

import cn.ccf.pojo.Case;
import cn.ccf.pojo.CaseExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CaseMapper {
    int countByExample(CaseExample example);

    int deleteByExample(CaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Case record);

    int insertSelective(Case record);

    List<Case> selectByExample(CaseExample example);

    Case selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Case record, @Param("example") CaseExample example);

    int updateByExample(@Param("record") Case record, @Param("example") CaseExample example);

    int updateByPrimaryKeySelective(Case record);

    int updateByPrimaryKey(Case record);
}