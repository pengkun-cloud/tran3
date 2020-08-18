package com.fh.meeting.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.meeting.model.Meeting;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public  interface MeetingMapper extends BaseMapper<Meeting> {
}
