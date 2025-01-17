package org.example.demo.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.demo.dao.model.*;
import org.example.demo.service.MovieService;
import org.example.demo.service.SeatService;
import org.example.demo.service.ShowtimeService;
import org.example.demo.service.TicketService;

import java.io.IOException;

@WebServlet(name = "HistoryController", urlPatterns = "/history")

public class HistoryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TicketService ticketService = new TicketService();
        MovieService movieService = new MovieService();
        ShowtimeService showtimeService = new ShowtimeService();
        SeatService seatService = new SeatService();
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        if (session == null || user == null) {
            response.sendRedirect("Pages/login.jsp");
            return;
        }
        Movie movie = movieService.getMovieById(ticketService.getMovieTicketByUserId(user.getId()).getShowTimeId());
        Showtime showtime = showtimeService.getShowtimeById(ticketService.getMovieTicketByUserId(user.getId()).getShowTimeId());
        FoodTicketItem foodTicketItem = ticketService.getFoodTicketItemByUserId(user.getId());
        MovieTickets movieTickets = ticketService.getMovieTicketByUserId(user.getId());
        Seat seat = seatService.getSeatById(movieTickets.getSeatId());

        request.setAttribute("movie", movie);
        request.setAttribute("showtime", showtime);
        request.setAttribute("foodTicketItem", foodTicketItem);
        request.setAttribute("movieTickets", movieTickets);
        request.setAttribute("seat", seat);
        request.getRequestDispatcher("Pages/history.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}