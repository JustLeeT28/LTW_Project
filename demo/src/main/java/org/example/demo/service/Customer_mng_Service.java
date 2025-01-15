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

    public void unBlockCustomer(int idStatusUnblock) {
        userDao.unBlockCustomer(idStatusUnblock);
    }

    public void delCustomer(int idUserdel) {
        userDao.delCustomer(idUserdel);
    }

    public List<User> getCustomer(String queryCus) {
        if(isEmail(queryCus)) {
            return  userDao.getCustomerByEmail(queryCus);
        }
        return  userDao.getCustomerByName(queryCus);

    }
    public static boolean isEmail(String queryCus) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        // So sánh với regex.
        return queryCus.matches(emailRegex);
    }


}
