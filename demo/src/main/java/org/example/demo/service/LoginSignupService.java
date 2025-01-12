package org.example.demo.service;

import org.example.demo.dao.UserDao;
import org.example.demo.dao.model.User;

public class LoginSignupService {
    UserDao userDao = new UserDao();
    public User getUser(String username, String password) {
        return userDao.getUser(username,password);
    }
}
