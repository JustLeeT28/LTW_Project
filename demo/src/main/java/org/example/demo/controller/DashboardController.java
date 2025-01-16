package org.example.demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.demo.dao.model.Genre;
import org.example.demo.dao.model.Movie;
import org.example.demo.dao.model.User;
import org.example.demo.service.DashboardService;
import org.example.demo.service.MovieService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "dashboardController", value = "/dashboard")

public class DashboardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isAdminLoggedIn(request)) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // Trả về lỗi 404
            return;
        }
        String date = request.getParameter("date");

        DashboardService service = new DashboardService();

        double total_revenue = service.getTotalR7();


        request.setAttribute("date", date);
        request.setAttribute("total_revenue", total_revenue);
        request.getRequestDispatcher("Admin/dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private boolean isAdminLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Lấy session (không tạo mới)
        if (session == null) return false;

        // Lấy thông tin role từ session
        User u = (User) session.getAttribute("user");
        return u != null && u.getRole() == 1; // Kiểm tra quyền là admin (1)
    }
}