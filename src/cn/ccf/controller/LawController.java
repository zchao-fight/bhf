package cn.ccf.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.ccf.constants.DetailType;
import cn.ccf.mapper.LawMapper;
import cn.ccf.mapper.MediaMapper;
import cn.ccf.pojo.Law;
import cn.ccf.pojo.LawExample;
import cn.ccf.pojo.Media;

@Controller
public class LawController {
	
	@Autowired
	private LawMapper lawMapper;
	
	@Autowired
	private MediaMapper mediaMapper;
	/**
	 * 
	 * @param req
	 * @param id
	 * @return
	 */
	@RequestMapping("/law/detail")
	public String detail(HttpServletRequest req, int id) {
		req.setAttribute("type", DetailType.LAW.getType());
		req.setAttribute("data", lawMapper.selectByPrimaryKey(id));
		
		return "law/details";
	}
	
	@RequestMapping("/law/more")
	public String more(HttpServletRequest req, Integer page) {
		req.setAttribute("type", DetailType.LAW.getType());
		
		LawExample lawExample = new LawExample();
		//lawExample.setOrderByClause("createdate DESC");
		page = page == null ? 1 : page;
		PageHelper.startPage(page, 20);
		List<Law> law = lawMapper.selectByExample(lawExample); 
		req.setAttribute("data", new PageInfo<Law>(law));
		req.setAttribute("url", "law/detail.action?id=");
		req.setAttribute("pageurl", "law/more.action?page=");
		
		return "law/more";
		
	}
	
}
