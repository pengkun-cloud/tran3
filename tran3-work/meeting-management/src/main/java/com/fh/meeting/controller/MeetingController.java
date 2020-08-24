package com.fh.meeting.controller;

import com.fh.meeting.common.ServerResponse;
import com.fh.meeting.model.Meeting;
import com.fh.meeting.param.MeetingParam;
import com.fh.meeting.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("meeting")
@CrossOrigin
public class MeetingController {
    @Autowired
    private MeetingService meetingService;


    //查询会议管理
    @RequestMapping("queryMeetingList")
    public ServerResponse queryMeetingList(MeetingParam meetingParam){
        long totalCount = meetingService.selectCountt(meetingParam);
        List<Meeting> meetingList=meetingService.queryMeetingList(meetingParam);
        Map<String,Object> map =new HashMap();
        map.put("totalCount",totalCount);
        map.put("meetingList",meetingList);
        return ServerResponse.success(map);
    }


    @RequestMapping("addMeeting")
    public ServerResponse addMeeting(Meeting meeting){
        return meetingService.addMeeting(meeting);
    }

    @RequestMapping("deleteMeeting/{meetingId}")
    public ServerResponse deleteMeeting(@PathVariable("meetingId") Integer meetingId){
        meetingService.deleteMeeting(meetingId);
        return  ServerResponse.success();
    }
    //批量删
    @RequestMapping("deleteBatch")
    public ServerResponse deleteBatch(@RequestParam("idList") List list){
        meetingService.deleteBatch(list);
        return  ServerResponse.success();

    }
    @RequestMapping("updateMeeting")
    public ServerResponse updateMeeting(Meeting meeting){
        meetingService.updateMeeting(meeting);
        return  ServerResponse.success();

    }

}
