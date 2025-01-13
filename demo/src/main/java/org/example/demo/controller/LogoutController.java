package org.example.demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LogoutController", urlPatterns = {"/LogoutController"})
public class LogoutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy session hiện tại, nếu có
        HttpSession session = request.getSession(false);

        // Kiểm tra và xóa toàn bộ dữ liệu trong session
        if (session != null) {
            session.invalidate(); // Hủy session
        }

        // Chuyển hướng về trang chủ
        response.sendRedirect("/demo_war_exploded");
    }
}
