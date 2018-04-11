package cn.ccf.forum.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.ccf.forum.model.Board;
import cn.ccf.forum.model.Person;


public interface PersonDAO {
	
	public void save(Person person);
	
	public int insert(Person person);
	
	public Person selectById(int id);
	
	public List<Board> selectBoardByPersonId(int id);
	
	public List<Person> selectAll();
	
	public Person findPersonByAccount(String account);
	
	public Person getPerson(Person person);
	
	public int deleteByBoardId(int id);
	
	public int insertBoardAdministrator(int boardId, int personId);
}
