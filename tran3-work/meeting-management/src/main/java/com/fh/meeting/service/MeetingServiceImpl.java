package com.fh.meeting.service;

import com.fh.meeting.common.ServerResponse;
import com.fh.meeting.mapper.MeetingMapper;
import com.fh.meeting.model.Meeting;
import com.fh.meeting.param.MeetingParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MeetingServiceImpl implements MeetingService{

    @Autowired
    private MeetingMapper meetingMapper;

    @Override
    public List<Meeting> queryMeetingList(MeetingParam meetingParam) {
        return meetingMapper.queryMeetingList(meetingParam);
    }

    @Override
    public ServerResponse addMeeting(Meeting meeting) {
        meetingMapper.addMeeting(meeting);
        return ServerResponse.success();
    }

    @Override
    public void deleteMeeting(Integer meetingId) {
        meetingMapper.deleteMeeting(meetingId);
    }

    @Override
    public void deleteBatch(List list) {
        meetingMapper.deleteBatch(list);
    }

    @Override
    public void updateMeeting(Meeting meeting) {
        meetingMapper.updateMeeting(meeting);
    }

    @Override
    public long selectCountt(MeetingParam meetingParam) {
        return meetingMapper.selectCountt(meetingParam);
    }
}
