package com.fh.attendance.service.impl;

import com.fh.attendance.mapper.AttendanceMapper;
import com.fh.attendance.model.Attendance;
import com.fh.attendance.model.AttendanceQuery;
import com.fh.attendance.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceMapper attendanceMapper;

    @Override
    public List<Attendance> queryAttendanceList(AttendanceQuery attendanceQuery) {
        return attendanceMapper.queryAttendanceList(attendanceQuery);
    }

    @Override
    public void addAttendance(Attendance attendance) {
        attendanceMapper.addAttendance(attendance);
    }

    @Override
    public Attendance queryAttendanceById(Integer id) {
        return attendanceMapper.queryAttendanceById(id);
    }

    @Override
    public void updateAttendance(Attendance attendance) {
        attendanceMapper.updateAttendance(attendance);
    }

    @Override
    public void deleteAttendance(Integer id) {
        attendanceMapper.deleteAttendance(id);
    }

    @Override
    public void deleteBatchAttendance(List<Integer> list) {
        attendanceMapper.deleteBatchAttendance(list);
    }
}
