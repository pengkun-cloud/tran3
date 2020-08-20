package com.fh.meeting.service;

import com.fh.meeting.common.ServerResponse;
import com.fh.meeting.model.Meeting;

import java.util.List;

public interface MeetingService {
    ServerResponse queryMeetingList();

    ServerResponse addMeeting(Meeting meeting);

    void deleteMeeting(Integer meetingId);

    void deleteBatch(List list);

    void updateMeeting(Meeting meeting);
}
