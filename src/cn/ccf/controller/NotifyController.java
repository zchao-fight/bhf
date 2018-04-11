package cn.ccf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import cn.ccf.constants.SessionConst;
import cn.ccf.mapper.WDEmailMapper;
import cn.ccf.mapper.YZTEventMapper;
import cn.ccf.pojo.SessionUser;
import cn.ccf.pojo.WDEmail;
import cn.ccf.pojo.WDEmailExample;
import cn.ccf.pojo.WDEmailExample.Criteria;
import cn.ccf.pojo.YZTEvent;
import cn.ccf.pojo.YZTEventExample;

@Controller
public class NotifyController {

	@Autowired
	private WDEmailMapper emailMapper;

	@Autowired
	private YZTEventMapper yztEventMapper;

	@RequestMapping("/notify/getMsg")
	@ResponseBody
	public JSONObject getMsg(HttpSession session) {
		/*SessionUser user = (SessionUser) session.getAttribute(SessionConst.SESSION_USER);
		if(user == null){
			JSONObject result = new JSONObject();
			result.put("events", new ArrayList<>());
			result.put("emails", new ArrayList<>());
			return result;
		}

		WDEmailExample emailExample = new WDEmailExample();
		Criteria andRecipientEqualTo = emailExample.createCriteria().andStateEqualTo(0).andTypeEqualTo(0).andRecipientEqualTo(String.valueOf(user.getId()));
		emailExample.or(andRecipientEqualTo);
		List<WDEmail> selectByExample = emailMapper.selectByExample(emailExample);

		YZTEventExample yztEventExample = new YZTEventExample();
		cn.ccf.pojo.YZTEventExample.Criteria andStatusEqualTo = yztEventExample.createCriteria().andTouseridEqualTo(user.getId()).andStatusEqualTo(0);
		yztEventExample.or(andStatusEqualTo);
		List<YZTEvent> eventList = yztEventMapper.selectByExample(yztEventExample);

		JSONObject result = new JSONObject();
		result.put("events", eventList);
		result.put("emails", selectByExample);
		return result;*/
		return null;
	}

}
