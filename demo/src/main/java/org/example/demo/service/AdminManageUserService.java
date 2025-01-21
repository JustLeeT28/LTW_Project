package org.example.demo.service;

import org.example.demo.dao.UserDao;
import org.example.demo.dao.model.User;

public class AdminManageUserService {
    UserDao userDao = new UserDao();
    public User getUserById(int userid){
        return userDao.getUserById(userid);
    }
}
