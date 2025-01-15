package org.example.demo.service;

import org.example.demo.dao.RoomDao;
import org.example.demo.dao.model.Room;

import java.util.List;

public class RoomService {
    RoomDao roomDao = new RoomDao();
    public void updateRoomStyle(int i, String styleRoom) {
        roomDao.updateRoomStyle(i,styleRoom);
    }

    public void updateRoomOccupancy(int i, int i1) {
        roomDao.updateRoomOccupancy(i,i1);
    }

    public List<Room> getAllRoom() {
        return roomDao.getAllRoom();
    }

    public void blockRoom(int i) {
        return;
    }
}
