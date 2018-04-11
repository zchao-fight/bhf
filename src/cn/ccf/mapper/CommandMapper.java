package cn.ccf.mapper;

import cn.ccf.pojo.Command;
import cn.ccf.pojo.Record;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandMapper {
    void insertInToCommand(Command command);
    void insertInToRecord(Record record);
    int getAutoIncrementID();
}
