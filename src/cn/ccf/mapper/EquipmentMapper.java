package cn.ccf.mapper;

import cn.ccf.pojo.Equipment;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    Equipment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKeyWithBLOBs(Equipment record);

    int updateByPrimaryKey(Equipment record);
}