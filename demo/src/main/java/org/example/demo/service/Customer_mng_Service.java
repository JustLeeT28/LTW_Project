package org.example.demo.service;

import org.example.demo.dao.UserDao;
import org.example.demo.dao.model.User;

import java.util.List;

public class Customer_mng_Service {
    UserDao userDao = new UserDao();

    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    public void blockCustomer(int idStatusBlock) {
        userDao.blockCustomer(idStatusBlock);
    }
}
