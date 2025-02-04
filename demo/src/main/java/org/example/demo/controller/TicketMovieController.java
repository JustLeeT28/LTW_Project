package org.example.demo.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
        if (!isAdminLoggedIn(request)) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // Trả về lỗi 404
            return;
        }
        String query_tikket = request.getParameter("query_tikkets");

        TicketMovieService ticketMovieService = new TicketMovieService();

        List<MovieTicket> listMovieTicket = new ArrayList<>();
        if (query_tikket != null && !query_tikket.isEmpty()) {
            listMovieTicket = ticketMovieService.getTicketByQuery(query_tikket);
        } else{
            listMovieTicket = ticketMovieService.getTicketAll();
        }


        request.setAttribute("listMovieTicket", listMovieTicket);
        request.getRequestDispatcher("/Admin/tikket_mng.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // update giá vé
        String tik2D = request.getParameter("2Dtik");
        String tik3D = request.getParameter("3Dtik");
        String tik4D = request.getParameter("4Dtik");
        String tikImax = request.getParameter("Imax");
        String ticketId_del = request.getParameter("ticketId_del");


        TicketMovieService ticketMovieService = new TicketMovieService();
        if (ticketId_del != null && !ticketId_del.isEmpty()) {
            ticketMovieService.delTicketById(ticketId_del);
        }

        if (tik2D !=null && !tik2D.isEmpty() ) {
            ticketMovieService.update2D(Integer.parseInt(tik2D));
        }
        if (tik3D !=null && !tik3D.isEmpty() ) {
            ticketMovieService.update3D(Integer.parseInt(tik3D));
        }
        if (tik4D !=null && !tik4D.isEmpty() ) {
            ticketMovieService.update4D(Integer.parseInt(tik4D));
        }
        if (tikImax !=null && !tikImax.isEmpty() ) {
            ticketMovieService.updateImax(Integer.parseInt(tikImax));
        }
        doGet(request, response);

    }
    private boolean isAdminLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Lấy session (không tạo mới)
        if (session == null) return false;

        // Lấy thông tin role từ session
        User u = (User) session.getAttribute("user");
        return u != null && u.getRole() == 1; // Kiểm tra quyền là admin (1)
    }
}