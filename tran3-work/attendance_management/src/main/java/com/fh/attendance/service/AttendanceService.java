package com.fh.attendance.service;

import com.fh.attendance.model.Attendance;
import com.fh.attendance.model.AttendanceQuery;

import java.util.List;

public interface AttendanceService {
    List<Attendance> queryAttendanceList(AttendanceQuery attendanceQuery);

    void addAttendance(Attendance attendance);

    Attendance queryAttendanceById(Integer id);

    void updateAttendance(Attendance attendance);

    void deleteAttendance(Integer id);

    void deleteBatchAttendance(List<Integer> list);

}
