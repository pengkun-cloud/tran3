package com.fh.meeting.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.meeting.model.Meeting;
import com.fh.meeting.param.MeetingParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public  interface MeetingMapper extends BaseMapper<Meeting> {

    List<Meeting> queryMeetingList(MeetingParam meetingParam);

    void addMeeting(Meeting meeting);

    void deleteMeeting(Integer meetingId);

    void deleteBatch(List list);

    void updateMeeting(Meeting meeting);

    long selectCountt(MeetingParam meetingParam);
}
