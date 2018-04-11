package cn.ccf.forum.Service;

import java.util.List;

import cn.ccf.forum.model.Category;

public interface CategoryService {

	public List<Category> getList();
	
	public int create(Category category);
	
	public List<Category> getAll();
}
