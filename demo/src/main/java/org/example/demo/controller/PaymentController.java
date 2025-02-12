package org.example.demo.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.demo.dao.model.FoodTicketItem;
import org.example.demo.dao.model.MovieTickets;
import org.example.demo.dao.model.User;
import org.example.demo.service.SeatService;
import org.example.demo.service.TicketService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "PaymentController", urlPatterns = "/payment")

public class PaymentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        if (session == null || user == null) {
            response.sendRedirect("Pages/login.jsp");
            return;
        }
        TicketService ticketService = new TicketService();
        SeatService seatService = new SeatService();
        List<MovieTickets> movieTickets = (List<MovieTickets>) session.getAttribute("tickets");
        List<FoodTicketItem> foodTicketItems = (List<FoodTicketItem>) session.getAttribute("foodTicketItems");
        List<String> selectedSeats = (List<String>) session.getAttribute("selectedSeats");
        String showtimeId = (String) session.getAttribute("showtimeId");
        for (MovieTickets movieTicket : movieTickets) {
            ticketService.addMovieTicket(movieTicket);
        }
        for (FoodTicketItem foodTicketItem : foodTicketItems) {
            ticketService.addFoodTicketItem(foodTicketItem);
        }
        for (String s : selectedSeats){
            seatService.updateSeatStatus(Integer.parseInt(s), "booked", Integer.parseInt(showtimeId));
        }
        session.removeAttribute("tickets");
        session.removeAttribute("foodTicketItems");
        session.removeAttribute("showtimeId");
        session.removeAttribute("selectedSeats");
        session.removeAttribute("totalPrice");
        response.sendRedirect("http://localhost:8080/demo_war_exploded/");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}