package com.fh.meeting.service;

import com.fh.meeting.mapper.MeetingMapper;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingServiceImpl implements MeetingService{

    @Autowired
    private MeetingMapper meetingMapper;
}
