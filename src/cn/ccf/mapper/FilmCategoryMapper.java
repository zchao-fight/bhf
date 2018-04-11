package cn.ccf.mapper;

import cn.ccf.pojo.FilmCategory;
import cn.ccf.pojo.FilmCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmCategoryMapper {
    int countByExample(FilmCategoryExample example);

    int deleteByExample(FilmCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FilmCategory record);

    int insertSelective(FilmCategory record);

    List<FilmCategory> selectByExample(FilmCategoryExample example);

    FilmCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FilmCategory record, @Param("example") FilmCategoryExample example);

    int updateByExample(@Param("record") FilmCategory record, @Param("example") FilmCategoryExample example);

    int updateByPrimaryKeySelective(FilmCategory record);

    int updateByPrimaryKey(FilmCategory record);
}