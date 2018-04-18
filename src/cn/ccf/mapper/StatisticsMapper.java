package cn.ccf.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StatisticsMapper {
    List<String> getDistinctAddr();
}
