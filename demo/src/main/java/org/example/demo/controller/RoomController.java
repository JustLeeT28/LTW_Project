package org.example.demo.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.dao.model.MovieTicket;
import org.example.demo.dao.model.Room;
import org.example.demo.service.RoomService;
import org.example.demo.service.TicketMovieService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "roomController", value = "/room_mng")

public class RoomController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//
        RoomService roomService = new RoomService();
        List<Room> listRoom = new ArrayList<>();
        listRoom = roomService.getAllRoom();
        request.setAttribute("listRoom", listRoom);
        request.getRequestDispatcher("/Admin/room_mng.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // update giá vé
        String roomId = request.getParameter("roomId");
        String styleRoom = request.getParameter("style_room");
        String occupancy = request.getParameter("occupancy");
        String room_blockId = request.getParameter("roomId_block");
        String room_unBlock_id = request.getParameter("roomId_unBlock");

        RoomService roomService = new RoomService();
        if(roomId != null && styleRoom != null && !roomId.isEmpty() && !styleRoom.isEmpty() ) {
            roomService.updateRoomStyle(Integer.parseInt(roomId),styleRoom);
        }
        if(roomId != null && occupancy != null && !roomId.isEmpty() && !occupancy.isEmpty() ) {
            roomService.updateRoomOccupancy(Integer.parseInt(roomId),Integer.parseInt(occupancy));
        }
        if(room_blockId != null && !room_blockId.isEmpty()) {
            roomService.blockRoom(Integer.parseInt(room_blockId));
        }
        if(room_unBlock_id != null && !room_unBlock_id.isEmpty()) {
            roomService.unblockRoom(Integer.parseInt(room_unBlock_id));
        }
        doGet(request, response);

    }
}