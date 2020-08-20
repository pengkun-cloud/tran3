package com.fh.meeting.service;

import com.fh.meeting.common.ServerResponse;
import com.fh.meeting.mapper.MeetingMapper;
import com.fh.meeting.model.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingServiceImpl implements MeetingService{

    @Autowired
    private MeetingMapper meetingMapper;

    @Override
    public ServerResponse queryMeetingList() {
        List<Meeting> meetingList=meetingMapper.queryMeetingList();
        return ServerResponse.success(meetingList);
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
}
