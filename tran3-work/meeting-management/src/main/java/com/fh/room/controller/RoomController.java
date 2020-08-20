package com.fh.room.controller;

import com.fh.meeting.common.ServerResponse;
import com.fh.meeting.model.Meeting;
import com.fh.room.model.Room;
import com.fh.room.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("room")
public class RoomController {
    @Autowired
    private RoomService roomService;
    //查询会议室
    @RequestMapping("queryRoomList")
    public ServerResponse queryRoomList(){
        return roomService.queryRoomList();
    }
    //查询会议室
    @RequestMapping("RoomById")
    public ServerResponse RoomById(Integer roomId){
        return roomService.roomById(roomId);
    }

    @RequestMapping("addRoom")
    public ServerResponse addMeeting(Room room){
        return roomService.addRoom(room);
    }

    @RequestMapping("deleteRoom/{roomId}")
    public ServerResponse deleteRoom(@PathVariable("roomId") Integer roomId){
        roomService.deleteRoom(roomId);
        return  ServerResponse.success();
    }
    //批量删
    @RequestMapping("deleteBatch")
    public ServerResponse deleteBatch(@RequestParam("idList") List list){
        roomService.deleteBatch(list);
        return  ServerResponse.success();

    }
    @RequestMapping("updateRoom")
    public ServerResponse updateRoom(Room room){
        roomService.updateRoom(room);
        return  ServerResponse.success();

    }
}
