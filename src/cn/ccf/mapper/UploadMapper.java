package cn.ccf.mapper;

import cn.ccf.pojo.Upload;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadMapper {
    int insert(Upload record);
}