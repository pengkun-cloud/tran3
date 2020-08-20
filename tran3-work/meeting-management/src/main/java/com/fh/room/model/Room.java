package com.fh.room.model;

import lombok.Data;

@Data
public class Room {

    private Integer roomId;

    private String  roomName;
    //会议室地址
    private  String roomSite;
    //会议室人数
    private Integer roomSize;
    //设备情况
    private String roomFacility;
    //备注
    private String roomNotes;
}
