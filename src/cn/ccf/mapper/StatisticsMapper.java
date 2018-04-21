package cn.ccf.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StatisticsMapper {
    List<String> getDistinctAddr();
    List<Map<String, Object>> getEventType(@Param("addr") String[] addr, @Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> getEventNum(@Param("addr") String[] addr, @Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> getEventProp(@Param("addr") String[] addr, @Param("beginTime") String beginTime, @Param("endTime") String endTime);
    List<Map<String, Object>> getEventRegion(@Param("addr") String[] addr, @Param("beginTime") String beginTime, @Param("endTime") String endTime);
}
