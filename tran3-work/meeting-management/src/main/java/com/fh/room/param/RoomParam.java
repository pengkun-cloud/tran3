package com.fh.room.param;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class RoomParam extends Page {

    //会议室

    private String roomName;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
