package com.fh.attendance.controller;

import com.fh.attendance.model.Attendance;
import com.fh.attendance.model.AttendanceQuery;
import com.fh.attendance.service.AttendanceService;
import com.fh.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("attendance")
@CrossOrigin
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping("queryAttendanceList")
    public ServerResponse queryAttendanceList(AttendanceQuery attendanceQuery){
        List<Attendance> list = attendanceService.queryAttendanceList(attendanceQuery);
        return ServerResponse.scuess(list);
    }

    @RequestMapping("addAttendance")
    public ServerResponse addAttendance(Attendance attendance){
        attendanceService.addAttendance(attendance);
        return ServerResponse.scuess();
    }

    @RequestMapping("queryAttendanceById")
    public ServerResponse queryAttendanceById(Integer id){
        Attendance attendance = attendanceService.queryAttendanceById(id);
        return ServerResponse.scuess(attendance);
    }

    @RequestMapping("updateAttendance")
    public ServerResponse updateAttendance(Attendance attendance){
        attendanceService.updateAttendance(attendance);
        return ServerResponse.scuess();
    }

    @RequestMapping("deleteAttendance")
    public ServerResponse deleteAttendance(Integer id){
        attendanceService.deleteAttendance(id);
        return ServerResponse.scuess();
    }

    @RequestMapping("deleteBatchAttendance")
    public ServerResponse deleteBatchAttendance(@RequestParam("ids") List<Integer> list){
        attendanceService.deleteBatchAttendance(list);
        return ServerResponse.scuess();
    }


}
