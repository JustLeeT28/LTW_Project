package org.example.demo.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.dao.model.MovieTicket;
import org.example.demo.dao.model.Seat;
import org.example.demo.dao.model.Showtime;
import org.example.demo.service.ScheduleService;
import org.example.demo.service.TicketMovieService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "scheduleController", value = "/schedule_mng")

public class ScheduleController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Showtime> showtimes = new ArrayList<>();
        ScheduleService service = new ScheduleService();
        showtimes =  service.getAllShowtime();

        request.setAttribute("showtimes", showtimes);
        request.getRequestDispatcher("/Admin/schedule_mng.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String movieId = request.getParameter("movieId");
        String roomId = request.getParameter("roomId");
        String showDate = request.getParameter("showDate");
        String showTime = request.getParameter("showTime")+":00";
        ScheduleService service = new ScheduleService();
        if(roomId != null && !roomId.isEmpty() && showDate != null && !showDate.isEmpty() && showTime != null && !showTime.isEmpty() && movieId != null && !movieId.isEmpty()) {
            if (service.isConflict(movieId,roomId,showDate,showTime)){
                request.setAttribute("message", "Phim bị trùng lịch chiếu!"); // Lưu vào request để hiển thị lên JSP
//                request.getRequestDispatcher("/Admin/schedule_mng.jsp").forward(request, response);
                doGet(request, response);

            }
            int movieIdInt = Integer.parseInt(movieId);
            int roomIdInt = Integer.parseInt(roomId);

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localShowDate = LocalDate.parse(showDate, dateFormatter);

            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime localShowTime = LocalTime.parse(showTime, timeFormatter);

            service.addShowTime(movieId,roomId,showDate,showTime);
            Showtime s = service.GetShowtime(movieIdInt,roomIdInt,localShowDate,localShowTime);
            // them show_seatS
            List<Seat> listSeat = service.getListSeatsByRoomid(roomId);
            for (Seat seat : listSeat) {
                service.addSh_S(s.getId(),seat.getId(),seat.getIsActive());
            }
//            service.addShowAndSeat(s.getId(),movieId);

            request.setAttribute("message", "Thêm lịch chiếu thành công!"); // Lưu vào request để hiển thị lên JSP
//            request.getRequestDispatcher("/Admin/schedule_mng.jsp").forward(request, response);
            doGet(request, response);

        }
        request.setAttribute("message", "Lỗi trong quá trình thực hiện vui lòng nhập lại!"); // Lưu vào request để hiển thị lên JSP
        request.getRequestDispatcher("/Admin/schedule_mng.jsp").forward(request, response);
//        doGet(request, response);

    }
}