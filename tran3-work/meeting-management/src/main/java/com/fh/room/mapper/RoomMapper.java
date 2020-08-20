package com.fh.room.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.room.model.Room;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoomMapper extends BaseMapper<Room> {
    List<Room> queryRoomList();

    void addRoom(Room room);

    void deleteRoom(Integer roomId);

    void deleteBatch(List list);

    void updateRoom(Room room);
}
