package org.example.demo.service;

import org.example.demo.dao.RoomDao;

public class RoomService {
    RoomDao roomDao = new RoomDao();
    public void updateRoomStyle(int i, String styleRoom) {
        roomDao.updateRoomStyle(i,styleRoom);
    }

    public void updateRoomOccupancy(int i, int i1) {
        roomDao.updateRoomOccupancy(i,i1);
    }
}
