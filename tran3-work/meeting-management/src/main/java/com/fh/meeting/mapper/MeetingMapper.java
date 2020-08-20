package com.fh.meeting.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.meeting.model.Meeting;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public  interface MeetingMapper extends BaseMapper<Meeting> {

    List<Meeting> queryMeetingList();

    void addMeeting(Meeting meeting);

    void deleteMeeting(Integer meetingId);

    void deleteBatch(List list);

    void updateMeeting(Meeting meeting);
}
