package org.example.demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.demo.dao.HashUtil;
import org.example.demo.dao.model.User;
import org.example.demo.service.LoginSignupService;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "Login_singup", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userEmail = request.getParameter("user_login");
        String password = request.getParameter("user_pass_login");
        // Mã hóa mật khẩu bằng MD5
//        HashUtil hashUtil = new HashUtil();
        String hashedPassword = HashUtil.hashWithMD5(password) ;
//        String hashedPassword = hashMD5(password);
        LoginSignupService loginSignupService = new LoginSignupService();
        if(userEmail != null && password != null) {
            User u = loginSignupService.getUser(userEmail, hashedPassword);
            if(u != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("user", u);
//                session.setAttribute("userName", u.getName());
//                session.setAttribute("userEmail", u.getEmail());
//                session.setAttribute("userDob", u.getDob());
//                session.setAttribute("userPhone", u.getPhone());
//                session.setAttribute("userRole", u.getRole());
//                session.setAttribute("userStatus", u.getStatus());
                response.sendRedirect("/demo_war_exploded");
                return;
            }
            request.setAttribute("errorMessage", "Tài khoản không tồn tại!");
            // Load lại trang đăng nhập với thông báo lỗi
            request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
            return;
        }
        request.setAttribute("errorMessage", "Vui lòng nhập đầy đủ thông tin!");
        request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
        return;
    }

//     Hàm mã hóa MD5
    private static String hashMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

//    public static void main(String[] args) {
//        // Kiểm tra hàm mã hóa MD5
//        String password = "Dung12345";
//        String hashedPassword = hashMD5(password);
//        System.out.println("Mật khẩu mã hóa MD5 là: " + hashedPassword);
//
//        // Kiểm tra đăng nhập
//        String userEmail = "phamthidung@gmail.com";
//        LoginController loginController = new LoginController();
//        loginController.login(userEmail, hashedPassword);
//        LoginSignupService loginSignupService = new LoginSignupService();
//        User u =  loginSignupService.getUser(userEmail, hashedPassword);
//        if(u != null) {
//            System.out.println(u);
//        }
//        System.out.println("không có người dùng này");
//
//    }
}