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


@WebServlet(name = "Login_singup", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Đăng nhập
        String userEmail = request.getParameter("user_login");
        String password = request.getParameter("user_pass_login");

        // Đăng ký
        String signup_user_email = request.getParameter("signup_user_email");
        String signup_user_name = request.getParameter("signup_user_name");
        String signup_user_pass = request.getParameter("signup_user_pass");

        // Dịch vụ login/signup
        LoginSignupService loginSignupService = new LoginSignupService();

        if (userEmail != null && password != null && !userEmail.isEmpty() && !password.isEmpty()) {  // Kiểm tra thông tin đăng nhập
            // Nếu thông tin hợp lệ, mã hóa mật khẩu và kiểm tra tài khoản
            String hashedPassword = HashUtil.hashWithMD5(password);
            User u = loginSignupService.getUser(userEmail, hashedPassword);
            if (u != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("user", u);
                session.setAttribute("isLogin", "true" );
                if(u.getRole() == 1){ // nếu tài khoản là admin
                    response.sendRedirect("/demo_war_exploded/dashboard");
                    return;
                }
                response.sendRedirect("/demo_war_exploded");
                return;
            }
            // Nếu tài khoản không tồn tại
            request.setAttribute("errorMessage", "Tài khoản hoặc mật khẩu không đúng!");
            request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
            return;
        }

        // Đăng ký
        if (signup_user_email != null && !signup_user_email.isEmpty() &&
                signup_user_name != null && !signup_user_name.isEmpty() &&
                signup_user_pass != null && !signup_user_pass.isEmpty()) {

            // Kiểm tra mật khẩu trong đăng ký
            String hashedPassword2_signup = HashUtil.hashWithMD5(signup_user_pass);
            User us = loginSignupService.createUser(signup_user_email, signup_user_name, hashedPassword2_signup);
            if (us != null) {
                request.setAttribute("errorMessage", "Đăng ký thành công!");
                request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
                return;
            } else {
                request.setAttribute("errorMessage", "Đăng ký thất bại! email đã được sử dụng");
                request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
                return;
            }
        }

        // Nếu không đủ thông tin
        request.setAttribute("errorMessage", "Vui lòng nhập đầy đủ thông tin!");
        request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
        return;
        }

//     Hàm mã hóa MD5
//    private static String hashMD5(String input) {
//        try {
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            byte[] messageDigest = md.digest(input.getBytes());
//            StringBuilder sb = new StringBuilder();
//            for (byte b : messageDigest) {
//                sb.append(String.format("%02x", b));
//            }
//            return sb.toString();
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException("Error hashing password", e);
//        }
//    }

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