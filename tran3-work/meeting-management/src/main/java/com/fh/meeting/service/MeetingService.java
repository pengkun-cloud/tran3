package com.fh.meeting.service;

import com.fh.meeting.common.ServerResponse;
import com.fh.meeting.model.Meeting;
import com.fh.meeting.param.MeetingParam;

import java.util.List;

public interface MeetingService {
    List<Meeting> queryMeetingList(MeetingParam meetingParam);

    ServerResponse addMeeting(Meeting meeting);

    void deleteMeeting(Integer meetingId);

    void deleteBatch(List list);

    void updateMeeting(Meeting meeting);

    long selectCountt(MeetingParam meetingParam);
}
