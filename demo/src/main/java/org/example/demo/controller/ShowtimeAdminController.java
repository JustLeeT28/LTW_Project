package org.example.demo.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.example.demo.dao.db.ShowtimeAdminDAO;
import org.example.demo.dao.model.Showtime;
import org.example.demo.service.ShowtimeAdminService;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class ShowtimeAdminController extends HttpServlet {
    private ShowtimeAdminService showtimeService;

    @Override
    public void init() {
        Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
        ShowtimeAdminDAO showtimeDAO = new ShowtimeAdminDAO(connection);
        showtimeService = new ShowtimeAdminService(showtimeDAO);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Showtime> showtimes = showtimeService.getAllShowtimes();
            request.setAttribute("showtimes", showtimes);
            RequestDispatcher dispatcher = request.getRequestDispatcher("schedule_mng.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error retrieving showtimes.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("add".equals(action)) {
                int movieId = Integer.parseInt(request.getParameter("movieId"));
                int roomId = Integer.parseInt(request.getParameter("roomId"));
                String showDate = request.getParameter("showDate");
                String showTime = request.getParameter("showTime");

                Showtime showtime = new Showtime(movieId, roomId, showDate, showTime, "active");
                showtimeService.addShowtime(showtime);
            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                showtimeService.deleteShowtime(id);
            } else if ("update".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                int movieId = Integer.parseInt(request.getParameter("movieId"));
                int roomId = Integer.parseInt(request.getParameter("roomId"));
                String showDate = request.getParameter("showDate");
                String showTime = request.getParameter("showTime");
                String status = request.getParameter("status");

                Showtime showtime = new Showtime(id, movieId,roomId,showDate, showTime, status);
                showtimeService.updateShowtime(showtime);
            }
            response.sendRedirect("ShowtimeAdminController");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error processing request.");
        }
    }
}
