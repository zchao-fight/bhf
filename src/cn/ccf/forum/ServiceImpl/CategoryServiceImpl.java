package cn.ccf.forum.ServiceImpl;

import java.util.List;

import cn.ccf.forum.model.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ccf.forum.DAO.CategoryDAO;
import cn.ccf.forum.Service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	public List<Category> getList() {
		return categoryDAO.getList();
	}

	@Override
	public int create(Category category) {
		if(categoryDAO.selectByName(category.getName())!=null)
			throw new RuntimeException("类别 " + category.getName() + " 已经存在。");
		return categoryDAO.create(category);
	}

	@Override
	public List<Category> getAll() {
		return categoryDAO.getAll();
	}
}
