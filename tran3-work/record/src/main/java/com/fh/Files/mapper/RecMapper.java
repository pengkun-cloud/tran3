package com.fh.Files.mapper;

import com.fh.Files.model.Record;
import com.fh.Files.vo.RecordVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecMapper {

    List<RecordVo> queryrecord();

    void addrecord(Record rec);

    void updateecord(Record rec);

    void deleteecord(Integer recid);

    void deleteallecord(List id);

    RecordVo huixianecord(Integer recid);
}
