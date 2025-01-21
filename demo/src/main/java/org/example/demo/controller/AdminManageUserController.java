package org.example.demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.dao.model.User;
import org.example.demo.service.AdminManageUserService;

import java.io.IOException;

@WebServlet(name = "AdminManageUserController", urlPatterns = "/AdManageUser")
public class AdminManageUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uId = request.getParameter("uId");
        int userId = Integer.parseInt(uId);
        AdminManageUserService adminManageUserService = new AdminManageUserService();
        User user = adminManageUserService.getUserById(userId);


        request.setAttribute("user", user);
        request.getRequestDispatcher("Admin/customerChange_mng.jsp").forward(request, response);
    }
}
