package org.example.demo.service;

import org.example.demo.dao.RoomDao;
import org.example.demo.dao.UserDao;
import org.example.demo.dao.model.Room;
import org.example.demo.dao.model.User;

public class TikketPriceService {
    RoomDao roomDao = new RoomDao();
    public int getPrice(String style) {
        return roomDao.getPrice(style);
    }
}
