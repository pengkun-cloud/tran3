package com.fh.room.service;

import com.fh.meeting.common.ServerResponse;
import com.fh.room.mapper.RoomMapper;
import com.fh.room.model.Room;
import com.fh.room.param.RoomParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public List<Room> queryRoomList(RoomParam roomParam) {
        return roomMapper.queryRoomList(roomParam);
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

    @Override
    public long selectCountt(RoomParam roomParam) {
        return roomMapper.selectCountt(roomParam);
    }
}
