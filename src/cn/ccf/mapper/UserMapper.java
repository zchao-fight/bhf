package cn.ccf.mapper;

import cn.ccf.pojo.User;
import cn.ccf.pojo.UserExample;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
	
	
	
	/**
	 * 以上为权限模块
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}