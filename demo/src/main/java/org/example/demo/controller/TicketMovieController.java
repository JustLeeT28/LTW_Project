package org.example.demo.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.dao.model.MovieTicket;
import org.example.demo.dao.model.User;
import org.example.demo.service.Customer_mng_Service;
import org.example.demo.service.TicketMovieService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ticketMovieController", value = "/tikket_mng")

public class TicketMovieController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query_tikket = request.getParameter("query_tikkets");

//        String idStatusBlock = request.getParameter("userId_status_block");
//        String idStatusUnblock = request.getParameter("userId_status_unblock");
//        String idUserdel = request.getParameter("userId_del");
          TicketMovieService ticketMovieService = new TicketMovieService();
//        // vô hiệu hóa tài khoản
//        if (idStatusBlock != null && !idStatusBlock.isEmpty()) {
//            service.blockCustomer(Integer.parseInt(idStatusBlock));
//        }
//        // gỡ vô hiệu hóa tài khoản
//        if (idStatusUnblock != null && !idStatusUnblock.isEmpty()) {
//            service.unBlockCustomer(Integer.parseInt(idStatusUnblock));
//        }
//        if (idUserdel != null && !idUserdel.isEmpty()) {
//            service.delCustomer(Integer.parseInt(idUserdel));
//        }
        List<MovieTicket> listMovieTicket = new ArrayList<>();
        if (query_tikket != null && !query_tikket.isEmpty()) {
            listMovieTicket = ticketMovieService.getTicketByQuery(query_tikket);
        } else{
            listMovieTicket = ticketMovieService.getTicketAll();
        }


//        request.setAttribute("date", date);
        request.setAttribute("listMovieTicket", listMovieTicket);
        request.getRequestDispatcher("/Admin/tikket_mng.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}