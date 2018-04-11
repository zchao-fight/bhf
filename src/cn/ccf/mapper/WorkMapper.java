package cn.ccf.mapper;

import cn.ccf.pojo.Work;
import cn.ccf.pojo.WorkExample;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WorkMapper {
	
	String selectByDepartmentID(int departmentID);
	/**
	 * 以上为自己写的方法
	 * @param example
	 * @return
	 */
    int deleteByPrimaryKey(Integer id);

    int insert(Work record);

    int insertSelective(Work record);

    List<Work> selectByExample(WorkExample example);

    Work selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);
}