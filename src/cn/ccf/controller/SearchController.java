package cn.ccf.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ccf.constants.DetailType;
import cn.ccf.mapper.LawMapper;
import cn.ccf.mapper.NewsMapper;
import cn.ccf.mapper.NoticeMapper;
import cn.ccf.mapper.PreplanMapper;
import cn.ccf.mapper.WorkMapper;
import cn.ccf.pojo.Law;
import cn.ccf.pojo.LawExample;
import cn.ccf.pojo.News;
import cn.ccf.pojo.NewsExample;
import cn.ccf.pojo.Notice;
import cn.ccf.pojo.NoticeExample;
import cn.ccf.pojo.Work;
import cn.ccf.pojo.WorkExample;

/**
 * 
 * 搜索
 */
@Controller
public class SearchController {

	@Autowired
	private NoticeMapper noticeMapper;
	@Autowired
	private NewsMapper newsMapper;
	@Autowired
	private WorkMapper workMapper;
	@Autowired
	private LawMapper lawMapper;
	@Autowired
	private PreplanMapper preplanMapper;

	@RequestMapping("/search")
	public String search(HttpServletRequest req, String keyword) {
		
		/*String key = "";
		try {
			 key = new String(keyword.getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		String key = keyword;
		
		

		// 通知公告搜索
		NoticeExample noticeExample = new NoticeExample();
		noticeExample.or(noticeExample.createCriteria().andNameLike(likeKeyWord(key)));
		List<Notice> noticeList = noticeMapper.selectByExample(noticeExample);
		String str = DetailType.NOTICE.name();
		req.setAttribute(DetailType.NOTICE.name().toLowerCase(), noticeList);

		// 联防要闻搜索
		NewsExample newsExample = new NewsExample();
		newsExample.or(newsExample.createCriteria().andNameLike(likeKeyWord(key)));
		List<News> newList = newsMapper.selectByExample(newsExample);
		req.setAttribute(DetailType.NEWS.name().toLowerCase(), newList);

		// 工作动态搜索
		WorkExample workExample = new WorkExample();
		workExample.or(workExample.createCriteria().andNameLike(likeKeyWord(key)));
		List<Work> worklist = workMapper.selectByExample(workExample);
		req.setAttribute(DetailType.WORK.name().toLowerCase(), worklist);

		// 政策法规搜索
		LawExample lawExample = new LawExample();
		lawExample.or(lawExample.createCriteria().andNameLike(likeKeyWord(key)));
		List<Law> lawList = lawMapper.selectByExample(lawExample);
		req.setAttribute(DetailType.LAW.name().toLowerCase(), lawList);
/*
		// 联防yuan搜索
		PreplanExample preplanExample = new PreplanExample();
		preplanExample.or(preplanExample.createCriteria().andNameLike(likeKeyWord(key)));
		List<Preplan> preplanList = preplanMapper.selectByExample(preplanExample);
		req.setAttribute(DetailType.PREPLAN.name().toLowerCase(), preplanList);*/

		//汇总信息
		boolean haveNoSearchResult = CollectionUtils.isEmpty(noticeList)&&//
				CollectionUtils.isEmpty(newList)&&//
				CollectionUtils.isEmpty(worklist)&&//
				CollectionUtils.isEmpty(lawList);
		
		req.setAttribute("haveNoSearchResult", haveNoSearchResult);
		req.setAttribute("keyword", key);
		
		return "search";
	}

	private String likeKeyWord(String keyword) {
		return "%" + keyword + "%";
	}
}
