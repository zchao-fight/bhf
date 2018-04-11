package cn.ccf.mapper;

import cn.ccf.pojo.Media;
import cn.ccf.pojo.MediaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaMapper {
    int countByExample(MediaExample example);

    int deleteByExample(MediaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Media record);

    int insertSelective(Media record);

    List<Media> selectByExampleWithBLOBs(MediaExample example);

    List<Media> selectByExample(MediaExample example);

    Media selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Media record, @Param("example") MediaExample example);

    int updateByExampleWithBLOBs(@Param("record") Media record, @Param("example") MediaExample example);

    int updateByExample(@Param("record") Media record, @Param("example") MediaExample example);

    int updateByPrimaryKeySelective(Media record);

    int updateByPrimaryKeyWithBLOBs(Media record);

    int updateByPrimaryKey(Media record);
    
    /**
     * 根据flag标志位
     */
    
    List<Media> selectByFlags(Boolean flags);
    
    Media  selectBySourceIdAndType(int souceid,int type);
}