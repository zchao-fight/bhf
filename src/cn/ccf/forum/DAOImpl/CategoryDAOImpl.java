package cn.ccf.forum.DAOImpl;

import java.util.List;

import cn.ccf.forum.mapper.CategoryMapper;
import cn.ccf.forum.model.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.ccf.forum.DAO.CategoryDAO;

@Repository
public class CategoryDAOImpl implements CategoryDAO{

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<Category> getList() {
		return categoryMapper.getList();
	}

	@Override
	public int create(Category category) {
		return categoryMapper.insertSelective(category);
	}

	@Override
	public Category selectByName(String name) {
		return categoryMapper.selectByName(name);
	}

	@Override
	public List<Category> getAll() {
		return categoryMapper.getAll();
	}
}
