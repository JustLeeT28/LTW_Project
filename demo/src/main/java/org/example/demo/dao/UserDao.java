package org.example.demo.dao;
import org.example.demo.controller.LoginController;
import org.example.demo.dao.db.DbConnect;
import org.example.demo.dao.model.Genre;
import org.example.demo.dao.model.Movie;
import org.example.demo.dao.model.User;
import org.example.demo.service.MovieService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public User getUser(String username, String password) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM USERS WHERE email = ? AND password = ?";
            ps = DbConnect.get(query);
            ps.setString(1, username);
            ps.setString(2, password);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("dob"),
                        resultSet.getString("phone"),
                        resultSet.getInt("role"),
                        resultSet.getString("password"),
                        resultSet.getString("status")
                );
                return user; // lấy cái đầu tiên
            }
            return null ;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User createUser(String signupUserEmail, String signupUserName, String hashedPassword2Signup) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        if(checkEmail(signupUserEmail)){ // kiểm tra xem email đã đc su dụng chưa
            return null;
        }
        try {
            // Query để chèn người dùng mới vào bảng `users`
            String query = "INSERT INTO USERS (email, name, password, role, status) VALUES (?, ?, ?, ?, ?)";

            // Lấy PreparedStatement từ DbConnect
            ps = DbConnect.get(query);

            // Thiết lập tham số cho PreparedStatement
            ps.setString(1, signupUserEmail);
            ps.setString(2, signupUserName);
            ps.setString(3, hashedPassword2Signup); // mật khẩu đã mã hóa
            ps.setInt(4, 0);
            ps.setString(5, "active");

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return getUser(signupUserEmail, hashedPassword2Signup);
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean checkEmail(String email) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM USERS WHERE email = ?";
        ps = DbConnect.get(query);
        try {
            ps.setString(1,email);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        UserDao dao = new UserDao();
        String p = "Dung12345";
        String pmd5 = HashUtil.hashWithMD5(p);
        User user = dao.getUser("phamthidung@gmail.com", pmd5);
        if (user != null) {
            System.out.println("User found: " + user);
            System.out.println("User found: " + user.getEmail());
            System.out.println("User found: " + user.getPassword());
        } else {
            System.out.println("User not found.");
        }

    }
}