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

@WebServlet(name = "Forgost_pass", urlPatterns = "/forgotpassword")

public class ForgostPassController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forgotpass_user_email = request.getParameter("forgotpass_user_email");

        LoginSignupService loginSignupService = new LoginSignupService();
        if (forgotpass_user_email != null && !forgotpass_user_email.isEmpty()) {
            if(loginSignupService.changePass(forgotpass_user_email)){
                request.setAttribute("errorMessage", "Mật khẩu đã được khôi phục!");
                request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
                return;
            }
            request.setAttribute("errorMessage", "Email không tồn tại!");
            // k thông báo để tránh spam mail
            request.getRequestDispatcher("/Pages/login.jsp").forward(request, response);
            return;
        }
//        request.setAttribute("errorMessage", "Vui lòng nhập gmail!");
        request.getRequestDispatcher("/Pages/forgotpass.jsp").forward(request, response);

    }
}
