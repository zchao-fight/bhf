package cn.ccf.controller;

import pt.tumba.parser.*;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ccf.constants.DetailType;
import cn.ccf.constants.MediaType;
import cn.ccf.mapper.MediaMapper;
import cn.ccf.mapper.StyleMapper;
import cn.ccf.pojo.Media;
import cn.ccf.pojo.NoticeExample;
import cn.ccf.pojo.Style;
import cn.ccf.pojo.StyleExample;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class StyleController {
	@Autowired
	private StyleMapper styleMapper;
	@Autowired
	private MediaMapper mediaMapper;

	/**
	 * 详情
	 * 
	 * @param req
	 * @param id
	 * @return
	 * @throws UnsupportedEncodingException
	 */

	@RequestMapping("/style/detail")
	public String detail(HttpServletRequest req, int id)
			throws UnsupportedEncodingException {
		req.setAttribute("type", DetailType.STYLE.getType());

		Style style = styleMapper.selectByPrimaryKey(id);
		req.setAttribute("data", style);

		Media media = mediaMapper.selectBySourceIdAndType(id, MediaType.MH_BASIC_STYLE_MEDIA_ALL);
		if (media != null) {
			String temp = "/upload/"+ MediaType.MH_BASIC_STYLE_MEDIA_ALL +"/"+id +"/"+id+"."+media.getExtension();
			System.out.println(temp);
			req.setAttribute("accessory", "/upload/"
					+ MediaType.MH_BASIC_STYLE_MEDIA_ALL + "/" + id + "/" + id
					+ "." + media.getExtension());
			String accessoryName = media.getRemark();
			req.setAttribute("accessoryName", accessoryName);
		}

		Media contentMedia = mediaMapper.selectBySourceIdAndType(id,
				MediaType.MH_BASIC_STYLE_MEDIA_DOC);

		if (contentMedia != null) {
			String content = "/upload/" + MediaType.MH_BASIC_STYLE_MEDIA_DOC + "/"+ id + "/" + id + ".html";
			System.out.println(content);
			req.setAttribute("content", content);
		}
		
		String departmentName = styleMapper.selectByDepartmentID(id);
		req.setAttribute("departmentName", departmentName);

		return "style/details";
	}

	/**
	 * 更多
	 * 
	 * @param req
	 * @param id
	 * @return
	 */
	@RequestMapping("/style/more")
	public String more(HttpServletRequest req, Integer page) {
		req.setAttribute("type", DetailType.STYLE.getType());

		StyleExample styleExample = new StyleExample();
		styleExample.setOrderByClause("Stick DESC, CreateDate DESC");
		StyleExample.Criteria criteria = styleExample.createCriteria();
		criteria.andIssueEqualTo(1);
		page = page == null ? 1 : page;
		PageHelper.startPage(page, 20);
		List<Style> style = styleMapper.selectByExample(styleExample);
		req.setAttribute("data", new PageInfo<Style>(style));
		req.setAttribute("url", "style/detail.action?id=");
		req.setAttribute("pageurl", "style/more.action?page=");
		return "style/more";
	}
}
