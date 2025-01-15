package org.example.demo.service;

import org.example.demo.dao.UserDao;
import org.example.demo.dao.model.User;

public class UserService {
    UserDao userDao = new UserDao();
    public void updateName(String userId, String name) {
        userDao.updateName(userId,name);
    }
    public void updateEmail(String userId, String email) {
        userDao.updateEmail(userId,email);
    }
    public void updateDob(String userId, String dob) {
        userDao.updateDob(userId,dob);
    }
    public void updatePhone(String userId, String phone) {
        userDao.updatePhone(userId,phone);
    }

    public User getUserById(String userId) {
        return userDao.getUserById(userId);
    }
}
