package com.fh.meeting.controller;

import com.fh.meeting.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("meeting")
public class MeetingController {
    @Autowired
    private MeetingService meetingService;


}
