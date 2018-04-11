package cn.ccf.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;






import pt.tumba.parser.doc.DOC2HTML;
import pt.tumba.parser.rtf.RTF2HTML;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.ccf.constants.DetailType;
import cn.ccf.constants.MediaType;
import cn.ccf.mapper.MediaMapper;
import cn.ccf.mapper.NoticeMapper;
import cn.ccf.pojo.Media;
import cn.ccf.pojo.NewsExample;
import cn.ccf.pojo.Notice;
import cn.ccf.pojo.NoticeExample;

/**
 * 通知公告
 * 
 * @author inohting
 *
 */

@Controller
public class NoticeController {

	@Autowired
	private NoticeMapper mapper;
	@Autowired
	private MediaMapper mediaMapper;
	

	/**
	 * 详情
	 * @param req
	 * @param id
	 * @return
	 */
	@RequestMapping("/notice/detail")
	public String detail(HttpServletRequest req, int id) {
	
		/*req.setAttribute("type", DetailType.NOTICE.getType());
		req.setAttribute("data", mapper.selectByPrimaryKey(id));
		
		Media media = mediaMapper.selectBySourceIdAndType(id, MediaType.MH_NOTICE_MEDIA_ALL);
		if (media != null) {
			req.setAttribute("accessory", "/upload/"+MediaType.MH_NOTICE_MEDIA_ALL+"/"+id+"/"+id+"." + media.getExtension());
			//String accessoryName =  media.getRemark()+"."+media.getExtension();
			String accessoryName =  media.getRemark();
			req.setAttribute("accessoryName", accessoryName);
		}
		
		Media contentMedia = mediaMapper.selectBySourceIdAndType(id, MediaType.MH_NOTICE_MEDIA_DOC);
		
		if (contentMedia != null) {
			String content = "/upload/"+MediaType.MH_NOTICE_MEDIA_DOC+"/"+id+"/"+id+".html";
			req.setAttribute("content", content); 
		}*/
		req.setAttribute("type", DetailType.NOTICE.getType()); 
		req.setAttribute("data", mapper.selectByPrimaryKey(id));
		
		Media media = mediaMapper.selectBySourceIdAndType(id, MediaType.MH_NOTICE_MEDIA_ALL);
		if (media != null) {
			req.setAttribute("accessory", "/upload/"+MediaType.MH_NOTICE_MEDIA_ALL+"/"+id+"/"+id+"." + media.getExtension());
			String accessoryName =  media.getRemark();
			req.setAttribute("accessoryName", accessoryName);
		}
		
		String filePath = "d:/upload/"+ MediaType.MH_NOTICE_MEDIA_RTF+"/"+id+"/"+id+".rtf";
		try {
			String tempHTML = new RTF2HTML().convertRTFToHTML(new File(filePath));
			String contentHTML = new String(tempHTML.getBytes("iso-8859-1"),"GBK");
			req.setAttribute("content", contentHTML);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("读取通知公告rtf文件出现异常");
		}
		
		String departmentName = mapper.selectByDepartmentID(id);
		req.setAttribute("departmentName", departmentName);
		
		return "notice/details";
	}
	
	/**
	 * 更多
	 * @param req
	 * @param id
	 * @return
	 */
	@RequestMapping("/notice/more")
	public String more(HttpServletRequest req, Integer page) {
		req.setAttribute("type", DetailType.NOTICE.getType());
		
		NoticeExample newExam = new NoticeExample();
		newExam.setOrderByClause("Stick Desc, CreateDate DESC");
		NoticeExample.Criteria criteria = newExam.createCriteria();
		criteria.andIssueEqualTo(1);
		page = page == null ? 1 : page;
		PageHelper.startPage(page, 20);
		List<Notice> news = mapper.selectByExample(newExam);
		req.setAttribute("data", new PageInfo<Notice>(news));
		req.setAttribute("url", "notice/detail.action?id=");
		req.setAttribute("pageurl", "notice/more.action?page=");
		return "notice/more";
	}

}
