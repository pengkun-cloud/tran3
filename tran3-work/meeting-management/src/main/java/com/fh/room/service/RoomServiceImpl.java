package com.fh.room.service;

import com.fh.meeting.common.ServerResponse;
import com.fh.room.mapper.RoomMapper;
import com.fh.room.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public ServerResponse queryRoomList() {
        List<Room> roomList = roomMapper.queryRoomList();
        return ServerResponse.success(roomList);
    }

    @Override
    public ServerResponse roomById(Integer roomId) {
        Room room = roomMapper.selectById(roomId);
        return ServerResponse.success(room);
    }

    @Override
    public ServerResponse addRoom(Room room) {
        roomMapper.addRoom(room);
        return ServerResponse.success();
    }

    @Override
    public void deleteRoom(Integer roomId) {
        roomMapper.deleteRoom(roomId);
    }

    @Override
    public void deleteBatch(List list) {
        roomMapper.deleteBatch(list);
    }

    @Override
    public void updateRoom(Room room) {
        roomMapper.updateRoom(room);
    }
}
