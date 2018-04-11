package cn.ccf.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;

import cn.ccf.constants.DetailType;
import cn.ccf.constants.MediaType;
import cn.ccf.constants.SessionConst;
import cn.ccf.forum.mapper.ThreadMapper;
import cn.ccf.mapper.DutyMapper;
import cn.ccf.mapper.FilmMapper;
import cn.ccf.mapper.LawMapper;
import cn.ccf.mapper.MediaMapper;
import cn.ccf.mapper.NewsMapper;
import cn.ccf.mapper.NoticeMapper;
import cn.ccf.mapper.PreplanMapper;
import cn.ccf.mapper.StatMapper;
import cn.ccf.mapper.StyleMapper;
import cn.ccf.mapper.WorkMapper;
import cn.ccf.pojo.Duty;
import cn.ccf.pojo.DutyExample;
import cn.ccf.pojo.Film;
import cn.ccf.pojo.FilmExample;
import cn.ccf.pojo.Law;
import cn.ccf.pojo.LawExample;
import cn.ccf.pojo.Media;
import cn.ccf.pojo.MediaExample;
import cn.ccf.pojo.News;
import cn.ccf.pojo.NewsExample;
import cn.ccf.pojo.Notice;
import cn.ccf.pojo.NoticeExample;
import cn.ccf.pojo.Preplan;
import cn.ccf.pojo.PreplanExample;
import cn.ccf.pojo.SessionUser;
import cn.ccf.pojo.Style;
import cn.ccf.pojo.StyleExample;
import cn.ccf.pojo.Work;
import cn.ccf.pojo.WorkExample;
import cn.ccf.forum.model.Thread;

@Controller
public class IndexController {

	@Autowired
	private NewsMapper newsMapper;
	@Autowired
	private WorkMapper workMapper;
	@Autowired
	private NoticeMapper noticeMapper;
	@Autowired
	private LawMapper lawMapper;
	@Autowired
	private PreplanMapper preplanMapper;

	@Autowired
	private FilmMapper filmMapper;

	@Autowired
	private StyleMapper styleMapper;

	@Autowired
	private ThreadMapper threadMapper;
	@Autowired
	private DutyMapper dutyMapper;
	@Autowired
	private MediaMapper mediaMapper;

	@Autowired
	private StatMapper statMapper;

	/**
	 * @param req
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest req) throws Exception{

		NewsExample newsExam = new NewsExample();
		newsExam.setOrderByClause("CreateDate DESC");
		NewsExample.Criteria sixNews = newsExam.createCriteria();
		sixNews.andIssueEqualTo(1);
		PageHelper.startPage(1, 6);
		List<News> news = newsMapper.selectByExample(newsExam);
		req.setAttribute("news", news);

		NewsExample focusNewsExample = new NewsExample();
		NewsExample.Criteria newscriteria = focusNewsExample.createCriteria();
		newscriteria.andPushEqualTo(1);
		newscriteria.andIssueEqualTo(1);
		focusNewsExample.setOrderByClause("CreateDate DESC");
		PageHelper.startPage(1, 4);
		List<News> focuNews = newsMapper.selectByExample(focusNewsExample);
		req.setAttribute("focuNews", focuNews);

		WorkExample workExample = new WorkExample();
		workExample.setOrderByClause("CreateDate DESC");
		WorkExample.Criteria SixWork = workExample.createCriteria();
		SixWork.andIssueEqualTo(1);
		PageHelper.startPage(1, 6);
		List<Work> work = workMapper.selectByExample(workExample);
		req.setAttribute("work", work);

		WorkExample focusWorkExample = new WorkExample();
		WorkExample.Criteria workcriteria = focusWorkExample.createCriteria();
		workcriteria.andPushEqualTo(1);
		workcriteria.andIssueEqualTo(1);
		focusWorkExample.setOrderByClause("CreateDate DESC");
		PageHelper.startPage(1, 4);
		List<Work> focusWork = workMapper.selectByExample(focusWorkExample);
		req.setAttribute("focusWork", focusWork);

		NoticeExample noticeExample = new NoticeExample();
		noticeExample.setOrderByClause("CreateDate DESC");
		NoticeExample.Criteria sixNotice = noticeExample.createCriteria();
		sixNotice.andIssueEqualTo(1);
		PageHelper.startPage(1, 6);
		List<Notice> notice = noticeMapper.selectByExample(noticeExample);
		req.setAttribute("notice", notice);

		LawExample lawExample = new LawExample();
		lawExample.setOrderByClause("id DESC");
		PageHelper.startPage(1, 6);
		List<Law> law = lawMapper.selectByExample(lawExample);
		req.setAttribute("law", law);

		FilmExample filmExample = new FilmExample();
		filmExample.setOrderByClause("CreateTime DESC");
		PageHelper.startPage(1, 2);
		List<Film> film = filmMapper.selectByExample(filmExample);
		req.setAttribute("film", film);

		StyleExample styleExample = new StyleExample();
		styleExample.setOrderByClause("CreateDate DESC");
		StyleExample.Criteria styleCriteria = styleExample.createCriteria();
		styleCriteria.andIssueEqualTo(1);
		styleCriteria.andPushEqualTo(1);
		PageHelper.startPage(1, 1);
		List<Style> style = styleMapper.selectByExample(styleExample);
		req.setAttribute("style", style);

		// 显示焦点图
		MediaExample mediaExample = new MediaExample();
		MediaExample.Criteria criteria = mediaExample.createCriteria();
		mediaExample.setOrderByClause("UpdateTime desc");
		criteria.andTypeEqualTo(4097);
		PageHelper.startPage(1, 5);
		List<Media> media = mediaMapper.selectByExample(mediaExample);
		List<String> toppedPicture = new ArrayList<String>();
		if (media != null) {
			for (Iterator iterator = media.iterator(); iterator.hasNext();) {
				Media tempMedia = (Media) iterator.next();
				// toppedPicture.add(tempMedia.getRemark());
				toppedPicture.add(tempMedia.getId() + ".jpg");
			}
			req.setAttribute("toppedPicture", toppedPicture);

		}

		// 显示论坛帖子
		List<Thread> thread = threadMapper.selectPortalThread();
		req.setAttribute("thread", thread);

		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/ddE",
				Locale.CHINA);
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		// 当前时间，貌似多余，其实是为了所有可能的系统一致
		calendar.setTimeInMillis(System.currentTimeMillis());
		System.out.println("当前时间:" + format.format(calendar.getTime()));
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		System.out.println("周一时间:" + format.format(calendar.getTime()));
		String mondayStr = format.format(calendar.getTime());
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		System.out.println("周日时间:" + format.format(calendar.getTime()));
		String sundayStr = format.format(calendar.getTime());

		DutyExample dutyExample = new DutyExample();
		dutyExample.setOrderByClause("predate asc");
		DutyExample.Criteria dutyCriteria = dutyExample.createCriteria();
		dutyCriteria.andPredateBetween(mondayStr, sundayStr);
		SessionUser sessionUser = (SessionUser) req.getSession().getAttribute(
				SessionConst.SESSION_USER);
		if (sessionUser == null) {
			// 防止session失效
			dutyCriteria.andDepartmentidEqualTo("1");
		} else {
			dutyCriteria.andDepartmentidEqualTo(sessionUser.getDepartmentID());
		}
		List<Duty> duty = dutyMapper.selectByExample(dutyExample);
		req.setAttribute("duty", duty);

		if (duty.size() != 0) {
			int index = 0;
			String date = duty.get(0).getPredate();
			String week = date.substring(10);
			switch (week) {
			case "星期一":
				index = 1;
				break;
			case "星期二":
				index = 2;
				break;
			case "星期三":
				index = 3;
				break;
			case "星期四":
				index = 4;
				break;
			case "星期五":
				index = 5;
				break;
			case "星期六":
				index = 6;
				break;
			case "星期天":
				index = 7;
				break;
			}
			System.out.println(index);
			req.setAttribute("weekIndex", index);

		}

		// 选中主页
		req.setAttribute("type", DetailType.HOME.getType());

		return "index";
	}

}
