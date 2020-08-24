package com.fh.meeting.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Meeting {
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


}
