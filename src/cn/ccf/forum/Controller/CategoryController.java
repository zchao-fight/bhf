package cn.ccf.forum.Controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.ccf.forum.model.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import cn.ccf.forum.DAO.CategoryDAO;
import cn.ccf.forum.Service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping("category_list.do")
	public ModelAndView list(HttpServletRequest request){
		request.setAttribute("title", "德宏州党政军警民联防平台");
		List<Category> categoryList = categoryService.getList();
		request.setAttribute("categoryList", categoryList);
		return new ModelAndView("forum/category/listCategory");
	}
	
	@RequestMapping("category_initAdd.do")
	public ModelAndView initAdd(HttpServletRequest request){
		request.setAttribute("title", "添加类别");
		request.setAttribute("category", new Category());
		return new ModelAndView("forum/category/addCategory");
	}
	
	/*@RequestMapping("category_add.do")
	public ModelAndView add(@ModelAttribute Category category, HttpServletRequest request){
		request.setAttribute("title", "添加类别");
		category.setDatecreated(new Date());
		category.setDeleted(false);
		categoryService.create(category);
		return new ModelAndView("forum/category/success");
	}*/
	
	@RequestMapping("category_add.do")
	@ResponseBody
	public JSONObject add(@ModelAttribute @RequestBody Category category, HttpServletRequest request){
		request.setAttribute("title", "添加类别");
		
		JSONObject json = new JSONObject();
		if (category.getName() == "") {
			json.put("res", 0);
			return json;
		}
		
		if(categoryDAO.selectByName(category.getName())!=null) {
			json.put("res", 2);
			return json;
		}
		
		category.setDatecreated(new Date());
		category.setDeleted(false);
		categoryService.create(category);
		
		json.put("res", 1);
		return json;
		
	}

}
