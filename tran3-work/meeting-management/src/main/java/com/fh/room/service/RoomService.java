package com.fh.room.service;

import com.fh.meeting.common.ServerResponse;
import com.fh.room.model.Room;

import java.util.List;

public interface  RoomService {
    ServerResponse queryRoomList();

    ServerResponse roomById(Integer roomId);

    ServerResponse addRoom(Room room);

    void deleteRoom(Integer roomId);

    void deleteBatch(List list);

    void updateRoom(Room room);
}
