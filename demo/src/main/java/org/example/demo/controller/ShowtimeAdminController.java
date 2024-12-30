package org.example.demo.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.example.demo.dao.db.ShowtimeAdminDAO;
import org.example.demo.dao.models.Showtime;
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
                // Thêm lịch chiếu
                Showtime showtime = new Showtime();
                showtime.setMovieId(Integer.parseInt(request.getParameter("movieId")));
                showtime.setRoomId(Integer.parseInt(request.getParameter("roomId")));
                showtime.setShowDate(java.sql.Date.valueOf(request.getParameter("showDate")));
                showtime.setShowTime(java.sql.Time.valueOf(request.getParameter("showTime")));
                showtime.setStatus("active");
                showtimeService.addShowtime(showtime);
            } else if ("delete".equals(action)) {
                // Xóa lịch chiếu
                int id = Integer.parseInt(request.getParameter("id"));
                showtimeService.deleteShowtime(id);
            } else if ("update".equals(action)) {
                // Cập nhật lịch chiếu
                Showtime showtime = new Showtime();
                showtime.setId(Integer.parseInt(request.getParameter("id")));
                showtime.setMovieId(Integer.parseInt(request.getParameter("movieId")));
                showtime.setRoomId(Integer.parseInt(request.getParameter("roomId")));
                showtime.setShowDate(java.sql.Date.valueOf(request.getParameter("showDate")));
                showtime.setShowTime(java.sql.Time.valueOf(request.getParameter("showTime")));
                showtime.setStatus(request.getParameter("status"));
                showtimeService.updateShowtime(showtime);
            }
            response.sendRedirect("ShowtimeController");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error processing request.");
        }
    }
}
