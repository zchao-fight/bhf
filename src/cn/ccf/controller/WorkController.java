package cn.ccf.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.ccf.constants.DetailType;
import cn.ccf.constants.MediaType;
import cn.ccf.mapper.MediaMapper;
import cn.ccf.mapper.WorkMapper;
import cn.ccf.pojo.Media;
import cn.ccf.pojo.StyleExample;
import cn.ccf.pojo.Work;
import cn.ccf.pojo.WorkExample;

@Controller
public class WorkController {
	
	@Autowired
	private WorkMapper workMapper;
	@Autowired
	private MediaMapper mediaMapper;
	
	/**
	 * 详情
	 * @param req
	 * @param id
	 * @return
	 */
	@RequestMapping("work/detail")
	public String detail(HttpServletRequest req, int id) {
		
		
		
		req.setAttribute("type", DetailType.WORK.getType());
		req.setAttribute("data", workMapper.selectByPrimaryKey(id));
		
		Media media = mediaMapper.selectBySourceIdAndType(id, MediaType.MH_WORK_MEDIA_ALL);
		if (media != null) {
			req.setAttribute("accessory", "/upload/"+MediaType.MH_WORK_MEDIA_ALL+"/"+id+"/"+id+"." + media.getExtension());
			//String accessoryName =  media.getRemark()+"."+media.getExtension();
			String accessoryName =  media.getRemark();
			req.setAttribute("accessoryName", accessoryName);
		}
		
		//String filePath = "d:\\upload\\"+MediaType.MH_NEWS_MEDIA_DOC+"\\"+id+".rtf";
		//String contentHTML = "d:\\upload\\"+MediaType.MH_NEWS_MEDIA_DOC+"\\"+id+"\\"+id+".html";
		Media contentMedia = mediaMapper.selectBySourceIdAndType(id, MediaType.MH_WORK_MEDIA_DOC);
		
		if (contentMedia != null) {
			String content = "/upload/"+MediaType.MH_WORK_MEDIA_DOC+"/"+id+"/"+id+".html";
			req.setAttribute("content", content); 
		}
		
		String departmentName = workMapper.selectByDepartmentID(id);
		req.setAttribute("departmentName", departmentName);
		
		
		return "work/details";
	}
	
	/**
	 * 
	 * @param req
	 * @param page
	 * @return
	 */
	@RequestMapping("work/more")
	public String more(HttpServletRequest req, Integer page) {
		
		req.setAttribute("type", DetailType.WORK.getType());
		WorkExample workExample = new WorkExample();
		workExample.setOrderByClause("Stick DESC, CreateDate DESC");

		WorkExample.Criteria criteria = workExample.createCriteria();
		criteria.andIssueEqualTo(1);
		page = page == null ? 1 : page;
		PageHelper.startPage(page, 20);
		List<Work> work =workMapper.selectByExample(workExample);
		req.setAttribute("data", new PageInfo<Work>(work));
		req.setAttribute("url", "work/detail.action?id=");
		req.setAttribute("pageurl", "work/more.action?page=");
		
		return "work/more";
	}
	
}
