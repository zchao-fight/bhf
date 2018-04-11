package cn.ccf.forum.DAO;

import java.util.List;

import cn.ccf.forum.model.Category;

public interface CategoryDAO {

	public List<Category> getList();
	
	public int create(Category category);
	
	public Category selectByName(String name);
	
	public List<Category> getAll();
}
