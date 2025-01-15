package org.example.demo.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.dao.model.MovieTicket;
import org.example.demo.service.RoomService;
import org.example.demo.service.TicketMovieService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "roomController", value = "/room_mng")

public class RoomController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String query_tikket = request.getParameter("query_tikkets");
//
//        TicketMovieService ticketMovieService = new TicketMovieService();
//
//        List<MovieTicket> listMovieTicket = new ArrayList<>();
//        if (query_tikket != null && !query_tikket.isEmpty()) {
//            listMovieTicket = ticketMovieService.getTicketByQuery(query_tikket);
//        } else{
//            listMovieTicket = ticketMovieService.getTicketAll();
//        }
//
//
//        request.setAttribute("listMovieTicket", listMovieTicket);
        request.getRequestDispatcher("/Admin/room_mng.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // update giá vé
        String roomId = request.getParameter("roomId");
        String styleRoom = request.getParameter("style_room");
        String occupancy = request.getParameter("occupancy");

        RoomService roomService = new RoomService();
        if(roomId != null && styleRoom != null && !roomId.isEmpty() && styleRoom.isEmpty() ) {
            roomService.updateRoomStyle(Integer.parseInt(roomId),styleRoom);
        }
        if(roomId != null && occupancy != null && !roomId.isEmpty() && occupancy.isEmpty() ) {
            roomService.updateRoomOccupancy(Integer.parseInt(roomId),Integer.parseInt(occupancy));
        }



//        doGet(request, response);

    }
}