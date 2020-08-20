package com.fh.attendance.mapper;

import com.fh.attendance.model.Attendance;
import com.fh.attendance.model.AttendanceQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AttendanceMapper {
    List<Attendance> queryAttendanceList(AttendanceQuery attendanceQuery);

    void addAttendance(Attendance attendance);

    Attendance queryAttendanceById(Integer id);

    void updateAttendance(Attendance attendance);

    void deleteAttendance(Integer id);

    void deleteBatchAttendance(List<Integer> list);

}
