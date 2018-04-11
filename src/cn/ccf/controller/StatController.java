package cn.ccf.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.util.NumberComparer;
import org.apache.tools.ant.taskdefs.Java;
import org.apache.tools.ant.taskdefs.condition.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.ccf.constants.GVS_TYPE;
import cn.ccf.mapper.StatMapper;

/**
 * 统计
 */
@Controller
public class StatController {

	@Autowired
	private StatMapper statMapper;

	/**
	 * 资源统计
	 * 
	 * @return
	 */
	@RequestMapping(value = "/stat/resource", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject resource(HttpServletRequest req) {
		/*
		 * List<Map<String, Object>> comObjectGroupby =
		 * statMapper.comObjectGroupby(); List<Map<String, Object>>
		 * yztCameraGroupby = statMapper.yztCameraGroupby();
		 * 
		 * int[] statArr = new int[6]; if (comObjectGroupby != null) { for
		 * (Map<String, Object> map : comObjectGroupby) { Integer parseInt =
		 * (Integer) map.get("ObjType"); try { Long count = (Long)
		 * map.get("stat"); count = count == null ? 0 : count; if (parseInt < 6)
		 * { statArr[parseInt - 1] = statArr[parseInt - 1] + count.intValue(); }
		 * else { statArr[5] = statArr[5] + count.intValue(); }
		 * 
		 * } catch (NumberFormatException e) { e.printStackTrace(); } } }
		 * 
		 * if (yztCameraGroupby != null) { for (Map<String, Object> map :
		 * yztCameraGroupby) { Integer parseInt = (Integer) map.get("ObjType");
		 * try { Long count = (Long) map.get("stat"); count = count == null ? 0
		 * : count; if (parseInt < 6) { statArr[parseInt - 1] = statArr[parseInt
		 * - 1] + count.intValue(); } else { statArr[5] = statArr[5] +
		 * count.intValue(); }
		 * 
		 * } catch (NumberFormatException e) { e.printStackTrace(); } } }
		 */

		JSONObject jsonObj = new JSONObject();

		String[] type = req.getParameterValues("type");
		String[] typeName = req.getParameterValues("typeName");

		if (type != null && typeName != null) {
			int[] num = new int[type.length];

			for (int i = 0; i < type.length; i++) {
				if (Integer.parseInt(type[i]) == 1) {
					int num1 = statMapper.selectByyztCamType();// 摄像头
					num[i] = num1;
				} else {

					int num2 = statMapper.selectByComObjectType(Integer
							.parseInt(type[i]));
					num[i] = num2;
				}

			}
			jsonObj.put("num", num);
			jsonObj.put("name", typeName);
		} else {
			int num1 = statMapper.selectByyztCamType();// 摄像头
			int num2 = statMapper
					.selectByComObjectType(GVS_TYPE.GVS_TRAFFIC_WAY);// 通道
			int num3 = statMapper
					.selectByComObjectType(GVS_TYPE.GVS_TRAFFIC_PORT);// 口岸
			int num4 = statMapper
					.selectByComObjectType(GVS_TYPE.GVS_OBJOther_2);// 国门
			int num5 = statMapper
					.selectByComObjectType(GVS_TYPE.GVS_OBJOther_1);// 界碑

			String[] name = { "摄像头", "通道", "口岸", "国门", "界碑" };
			int[] num = { num1, num2, num3, num4, num5 };

			jsonObj.put("name", name);
			jsonObj.put("num", num);

		}

		return jsonObj;
	}

	/**
	 * 值班反馈及时率统计
	 * 
	 * @return
	 */
	@RequestMapping("/stat/duty")
	@ResponseBody
	public JSONObject duty(HttpServletRequest request) {
		/*
		 * List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		 * String time = request.getParameter("time"); if (time == null) { list
		 * = statMapper.selectDutyFeedBackByWeek();
		 * 
		 * } else { switch (time) { case "week": list =
		 * statMapper.selectDutyFeedBackByWeek(); break; case "month": list =
		 * statMapper.selectDutyFeedBackByMonth(); break; case "season": list =
		 * statMapper.selectDutyFeedBackBySeason(); break; case "year": list =
		 * statMapper.selectDutyFeedBackByYear(); break; default: list =
		 * statMapper.selectDutyFeedBackByWeek(); break; } }
		 * 
		 * String[] name = new String[list.size()]; Long[] num = new
		 * Long[list.size()]; Long maxLong = 0L; for (int i = 0; i <
		 * list.size(); i++) { Map<String, Object> map = list.get(i);
		 * 
		 * name[i] = (String) map.get("Name"); num[i] = (Long) map.get("num");
		 * 
		 * if (maxLong < num[i]) { maxLong = num[i]; }
		 * 
		 * }
		 * 
		 * JSONObject json = new JSONObject(); json.put("max", maxLong+1);
		 * json.put("name", name); json.put("num", num);
		 */

		List<Map<String, String>> listNotAllDay = statMapper.selectBySignNotAllDay();
		List<Map<String, String>> listAllDay = statMapper.selectBySignAllDay();

		List<Map<String, String>> listMerge = new ArrayList<Map<String, String>>();

		listMerge.addAll(listNotAllDay);
		listMerge.addAll(listAllDay);

		// 用于存放最后的结果
		List<Map<String, String>> countList = new ArrayList<Map<String, String>>();

		for (int i = 0; i < listMerge.size(); i++) {
			String gsId = listMerge.get(i).get("Name");
			int flag = 0;// 0为新增数据，1为增加count
			for (int j = 0; j < countList.size(); j++) {
				String gsId_ = countList.get(j).get("Name");
				if (gsId.equals(gsId_)) {
					int sum = Integer.parseInt(String.valueOf(listMerge.get(i)
							.get("num")))
							+ Integer.parseInt(String.valueOf(countList.get(j)
									.get("num")));
					countList.get(j).put("num", sum + "");
					flag = 1;
					continue;
				}
			}
			if (flag == 0) {
				countList.add(listMerge.get(i));
			}
		}

		String[] name = new String[countList.size()];
		int[] num = new int[countList.size()];
		for (int i = 0; i < countList.size(); i++) {
			Map<String, String> map = countList.get(i);
			name[i] = map.get("Name");
			num[i] = Integer.valueOf(String.valueOf(map.get("num")));

		}

		JSONObject json = new JSONObject();
		json.put("max",14);
		json.put("name", name);
		json.put("num", num);

		return json;
	}

	/**
	 * 联防平台事件程度
	 * 
	 * @return
	 */
	@RequestMapping("/stat/eventLevel")
	@ResponseBody
	public JSONObject eventLevel(HttpServletRequest request) {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String time = request.getParameter("time");
		if (time == null) {
			list = statMapper.selectByEventLevelAndMonth();
		} else {
			switch (time) {
			case "week":
				list = statMapper.selectByEventLevelAndWeek();
				break;
			case "month":
				list = statMapper.selectByEventLevelAndMonth();
				break;
			case "season":
				list = statMapper.selectByEventLevelAndSeason();
				break;
			case "year":
				list = statMapper.selectByEventLevelAndYear();
				break;
			default:
				list = statMapper.selectByEventLevelAndMonth();
				break;
			}
		}

		Long[] num = new Long[list.size()];
		String[] level = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = list.get(i);

			switch ((int) map.get("Level")) {
			case 1:
				level[i] = "轻度";
				break;
			case 2:
				level[i] = "中度";
				break;
			case 3:
				level[i] = "重度";
				break;
			default:
				break;
			}
			num[i] = (Long) map.get("num");

		}

		JSONObject json = new JSONObject();
		json.put("name", level);
		json.put("num", num);

		return json;
	}

	/**
	 * 事件类型统计
	 * 
	 * @return
	 */
	@RequestMapping("/stat/eventType")
	@ResponseBody
	public JSONObject eventType(HttpServletRequest request) {

		// 统计事件类型
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String time = request.getParameter("time");
		if (time == null) {
			list = statMapper.selectByEventTypeAndWeek();
		} else {
			switch (time) {
			case "week":
				list = statMapper.selectByEventTypeAndWeek();
				break;
			case "month":
				list = statMapper.selectByEventTypeAndMonth();
				break;
			case "season":
				list = statMapper.selectByEventTypeAndSeason();
				break;
			case "year":
				list = statMapper.selectByEventTypeAndYear();
				break;
			default:
				list = statMapper.selectByEventTypeAndMonth();
				break;
			}
		}

		String[] name = new String[list.size()];
		Long[] num = new Long[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = list.get(i);

			name[i] = (String) map.get("name");
			num[i] = (Long) map.get("num");

		}

		JSONObject json = new JSONObject();
		json.put("name", name);
		json.put("num", num);

		return json;
	}
	
	/**
	 * 事件类型统计
	 * 
	 * @return
	 */
	@RequestMapping("/stat/countPost")
	@ResponseBody
	public JSONObject countPost(HttpServletRequest request) {
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String type = request.getParameter("type");
		if (type == null) {
			list = statMapper.selectWork();
		} else {
			switch (type) {
			case "notice":
				list = statMapper.selectNotice();
				break;
			case "news":
				list = statMapper.selectNews();
				break;
			case "work":
				list = statMapper.selectWork();
				break;
			case "style":
				list = statMapper.selectStyle();
				break;
			case "law":
				list = statMapper.selectLaw();
				break;
			}
		}
	
		String[] name = new String[list.size()];
		Long[] num = new Long[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = list.get(i);
			name[i] = (String) map.get("Name");
			num[i] = (Long) map.get("num");

		}

		JSONObject json = new JSONObject();
		json.put("name", name);
		json.put("num", num);

		return json;
	}
	
	/**
	 * 各单位访问量统计
	 * @param request
	 * @return
	 */
	@RequestMapping("/stat/getVisit")
	@ResponseBody
	public JSONObject getVisit(HttpServletRequest request) {
		
		
		// 统计事件类型
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				list = statMapper.selectVisit();
				

				String[] name = new String[list.size()];
				Long[] num = new Long[list.size()];
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> map = list.get(i);

					name[i] = (String) map.get("Name");
					num[i] = (Long) map.get("num");

				}

				JSONObject json = new JSONObject();
				json.put("name", name);
				json.put("num", num);

				return json;
	}

}
