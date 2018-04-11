package cn.ccf.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface StatMapper {
	//资源统计
	List<Map<String, Object>> comObjectGroupby();
	List<Map<String, Object>> yztCameraGroupby();
	//根据类型得到资源个数
	int selectByComObjectType(int type);
	int selectByyztCamType();
	//值班反馈率
	List<Map<String, Object>> selectDutyFeedBackByWeek();
	List<Map<String, Object>> selectDutyFeedBackByMonth();
	List<Map<String, Object>> selectDutyFeedBackBySeason();
	List<Map<String, Object>> selectDutyFeedBackByYear();
	//实践程度统计分析
	List<Map<String, Object>> selectByEventLevelAndWeek();
	List<Map<String, Object>> selectByEventLevelAndMonth();
	List<Map<String, Object>> selectByEventLevelAndSeason();
	List<Map<String, Object>> selectByEventLevelAndYear();
	//事件统计分析
	List<Map<String, Object>> selectByEventTypeAndWeek();
	List<Map<String, Object>> selectByEventTypeAndMonth();
	List<Map<String, Object>> selectByEventTypeAndSeason();
	List<Map<String, Object>> selectByEventTypeAndYear();
	//值班签到次数统计
	List<Map<String, String>> selectBySignNotAllDay();
	List<Map<String, String>> selectBySignAllDay();
	//各单位发文量统计
	List<Map<String, Object>> selectNotice();
	List<Map<String, Object>> selectNews();
	List<Map<String, Object>> selectWork();
	List<Map<String, Object>> selectStyle();
	List<Map<String, Object>> selectLaw();
	//各单位访问量统计
	List<Map<String, Object>> selectVisit();
	
	
	
}