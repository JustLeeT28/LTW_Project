package org.example.demo.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.example.demo.dao.model.MovieTicket;
import org.example.demo.service.TicketAdminService;

import java.io.IOException;
import java.util.List;

public class TicketAdminController extends HttpServlet {
    private TicketAdminService ticketService;

    @Override
    public void init() {
        ticketService = (TicketAdminService) getServletContext().getAttribute("ticketService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("search".equals(action)) {
                String keyword = request.getParameter("keyword");
                List<MovieTicket> tickets = ticketService.searchTickets(keyword);
                request.setAttribute("tickets", tickets);
            } else {
                List<MovieTicket> tickets = ticketService.getAllBookedTickets();
                request.setAttribute("tickets", tickets);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/tikket_mng.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error while managing tickets.");
        }
    }
}
