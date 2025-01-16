package org.example.demo.controller;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.demo.dao.model.*;
import org.example.demo.service.FoodService;
import org.example.demo.service.MovieService;
import org.example.demo.service.SeatService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@WebServlet(name = "FoodController", urlPatterns = "/orderFood")
public class FoodController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Nhận tham số từ URL
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        if (session == null || (User) session.getAttribute("user") == null) {
            response.sendRedirect("Pages/login.jsp");
            return;
        }
        SeatService seatService = new SeatService();
        MovieService movieService = new MovieService();
        String movieId = request.getParameter("mId");  // Nhận movieId từ URL
        String showtimeId = request.getParameter("showtimeId");  // Nhận showtimeId từ URL
        String seatsId = request.getParameter("seatsId");  // Nhận danh sách ghế đã chọn từ URL
        Movie movie = movieService.getMovieById(Integer.parseInt(movieId));

        FoodService foodService = new FoodService();
        List<FoodCombo> foodCombos = foodService.getFoodCombo();

        // Chuyển chuỗi thành danh sách các ghế đã chọn (nếu cần)
        String[] selectedSeatsArray = seatsId.split(",");
        List<String> selectedSeats = Arrays.asList(selectedSeatsArray);

        List<MovieTickets> tickets = new ArrayList<>();
        for (String seatId : selectedSeats) {
            MovieTickets movieTicket = new MovieTickets();
            movieTicket.setSeatId(Integer.parseInt(seatId));
            movieTicket.setShowTimeId(Integer.parseInt(showtimeId));
            movieTicket.setPrice(seatService.getSeatById(Integer.parseInt(seatId)).getPrice());
            movieTicket.setUserId(user.getId());
            tickets.add(movieTicket);
        }

        session.setAttribute("tickets", tickets);

        request.setAttribute("movie", movie);
        request.setAttribute("movieId", movieId);
        request.setAttribute("showtimeId", showtimeId);
        request.setAttribute("seatsId", seatsId);
        request.setAttribute("tickets", tickets);
        request.setAttribute("foodCombos", foodCombos);
        request.setAttribute("user", user);
        request.getRequestDispatcher("Pages/order-food.jsp").forward(request, response);
    }
}
