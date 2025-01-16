package org.example.demo.service;

import org.example.demo.dao.UserDao;
import org.example.demo.dao.model.User;

public class LoginSignupService {
    UserDao userDao = new UserDao();
    public User getUser(String username, String password) {
        return userDao.getUser(username,password);
    }

    public User createUser(String signupUserEmail, String signupUserName, String hashedPassword2Signup) {
        return userDao.createUser(signupUserEmail,signupUserName,hashedPassword2Signup);
    }

    public boolean changePass(String forgotpassUserEmail) {
        return userDao.changePass(forgotpassUserEmail);
    }

    public void changePass2(int id, String hashNewPass) {
        userDao.changePass2(id,hashNewPass);
    }
}
