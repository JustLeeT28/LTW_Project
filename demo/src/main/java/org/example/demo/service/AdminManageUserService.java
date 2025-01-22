package org.example.demo.service;

import org.example.demo.dao.HashUtil;
import org.example.demo.dao.UserDao;
import org.example.demo.dao.model.User;

public class AdminManageUserService {
    UserDao userDao = new UserDao();
    public User getUserById(String userid){
        return userDao.getUserById(userid);
    }

    public void setName(String id, String username) {
        userDao.setName(id,username);
    }

    public void setPass(String id, String userpass) {
        HashUtil hashUtil = new HashUtil();
        String passhash = hashUtil.hashWithMD5(userpass);
        userDao.changePass2(Integer.parseInt(id),passhash);
    }

    public boolean checkEmail(String email) {
        return userDao.checkEmail(email);
    }
}
