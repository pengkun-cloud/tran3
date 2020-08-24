package com.fh.meeting.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MeetingVo{
    //会议Id
    private Integer meetingId;
    //会议主题
    private String meetingTheme;
    //参会人员
    private String conferee;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date meetingMinDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date meetingMaxDate;
    //会议室
    private Integer roomId;
    //会议室
    @TableField(exist = false)
    private String roomName;
    //会议类型
    private Integer meetingType;
    //主持人
    private String compere;
    //记录人
    private  String recorder;
    //登记人
    private String registrant;
    //登记时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date registerTime;

    //附件
    private String photo;
    //会议保障内容
    private  String meetingSafeWhad;
    //会议内容
    private String meetingWhad;
    //会议说明
    private  String meetingState;

    public Integer getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    public String getMeetingTheme() {
        return meetingTheme;
    }

    public void setMeetingTheme(String meetingTheme) {
        this.meetingTheme = meetingTheme;
    }

    public String getConferee() {
        return conferee;
    }

    public void setConferee(String conferee) {
        this.conferee = conferee;
    }

    public Date getMeetingMinDate() {
        return meetingMinDate;
    }

    public void setMeetingMinDate(Date meetingMinDate) {
        this.meetingMinDate = meetingMinDate;
    }

    public Date getMeetingMaxDate() {
        return meetingMaxDate;
    }

    public void setMeetingMaxDate(Date meetingMaxDate) {
        this.meetingMaxDate = meetingMaxDate;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getMeetingType() {
        return meetingType;
    }

    public void setMeetingType(Integer meetingType) {
        this.meetingType = meetingType;
    }

    public String getCompere() {
        return compere;
    }

    public void setCompere(String compere) {
        this.compere = compere;
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getMeetingSafeWhad() {
        return meetingSafeWhad;
    }

    public void setMeetingSafeWhad(String meetingSafeWhad) {
        this.meetingSafeWhad = meetingSafeWhad;
    }

    public String getMeetingWhad() {
        return meetingWhad;
    }

    public void setMeetingWhad(String meetingWhad) {
        this.meetingWhad = meetingWhad;
    }

    public String getMeetingState() {
        return meetingState;
    }

    public void setMeetingState(String meetingState) {
        this.meetingState = meetingState;
    }
}
