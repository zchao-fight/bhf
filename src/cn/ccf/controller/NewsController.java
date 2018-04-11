package cn.ccf.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pt.tumba.parser.rtf.RTF2HTML;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.ccf.constants.DetailType;
import cn.ccf.constants.MediaType;
import cn.ccf.mapper.MediaMapper;
import cn.ccf.mapper.NewsMapper;
import cn.ccf.pojo.Media;
import cn.ccf.pojo.News;
import cn.ccf.pojo.NewsExample;

/**
 * 边防要闻
 * 
 * @author inohting
 *
 */

@Controller
public class NewsController {

	@Autowired
	private NewsMapper newsMapper;
	@Autowired
	private MediaMapper mediaMapper;
	/**
	 * 详情
	 * @param req
	 * @param id
	 * @return
	 */
	@RequestMapping("/news/detail")
	public String detail(HttpServletRequest req, int id) throws Exception {

		req.setAttribute("type", DetailType.NEWS.getType());
		req.setAttribute("data", newsMapper.selectByPrimaryKey(id));
		
		Media media = mediaMapper.selectBySourceIdAndType(id, MediaType.MH_NEWS_MEDIA_ALL);
		if (media != null) {
			req.setAttribute("accessory", "/upload/"+MediaType.MH_NEWS_MEDIA_ALL+"/"+id+"/"+id+"." + media.getExtension());
			//String accessoryName =  media.getRemark()+"."+media.getExtension();
			String accessoryName =  media.getRemark();
			req.setAttribute("accessoryName", accessoryName);
		}
		
		//String filePath = "d:\\upload\\"+MediaType.MH_NEWS_MEDIA_DOC+"\\"+id+".rtf";
		//String contentHTML = "d:\\upload\\"+MediaType.MH_NEWS_MEDIA_DOC+"\\"+id+"\\"+id+".html";
		Media contentMedia = mediaMapper.selectBySourceIdAndType(id, MediaType.MH_NEWS_MEDIA_DOC);
		
		if (contentMedia != null) {
			String content = "/upload/"+MediaType.MH_NEWS_MEDIA_DOC+"/"+id+"/"+id+".html";
			req.setAttribute("content", content); 
		}
		
		
		//String str = new RTF2HTML().convertRTFToHTML(new File(filePath));
		//String content = new String(str.getBytes("iso-8859-1"),"gbk");
		//req.setAttribute("content", content);
		
		String departmentName = newsMapper.selectByDepartmentID(id);
		req.setAttribute("departmentName", departmentName);
		
		
		return "news/details";
	}
	
	/**
	 * 更多
	 * @param req
	 * @param
	 * @return
	 */
	@RequestMapping("/news/more")
	public String more(HttpServletRequest req, Integer page) {
		req.setAttribute("type", DetailType.NEWS.getType());
		
		NewsExample newsExam = new NewsExample();
		newsExam.setOrderByClause("Stick DESC, CreateDate DESC");
		
		NewsExample.Criteria criteria = newsExam.createCriteria();
		criteria.andIssueEqualTo(1);
		page = page == null ? 1 : page;
		PageHelper.startPage(page, 20);
		List<News> news = newsMapper.selectByExample(newsExam);
		req.setAttribute("data", new PageInfo<News>(news));
		req.setAttribute("url", "news/detail.action?id=");
		req.setAttribute("pageurl", "news/more.action?page=");
		return "news/more";
	}

}
