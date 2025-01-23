package org.example.demo.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.demo.dao.model.MovieTicket;
import org.example.demo.dao.model.User;
import org.example.demo.service.TicketMovieService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SeatsController", value = "/seats_mng")

public class SeatsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isAdminLoggedIn(request)) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // Trả về lỗi 404
            return;
        }
        String query_tikket = request.getParameter("query_tikkets");

        TicketMovieService ticketMovieService = new TicketMovieService();

        List<MovieTicket> listMovieTicket = new ArrayList<>();
        if (query_tikket != null && !query_tikket.isEmpty()) {
            listMovieTicket = ticketMovieService.getTicketByQuery(query_tikket);
        } else{
            listMovieTicket = ticketMovieService.getTicketAll();
        }


        request.setAttribute("listMovieTicket", listMovieTicket);
        request.getRequestDispatcher("/Admin/tikket_mng.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // update giá vé
        String tik2D = request.getParameter("2Dtik");

        doGet(request, response);

    }
    private boolean isAdminLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Lấy session (không tạo mới)
        if (session == null) return false;

        // Lấy thông tin role từ session
        User u = (User) session.getAttribute("user");
        return u != null && u.getRole() == 1; // Kiểm tra quyền là admin (1)
    }
}