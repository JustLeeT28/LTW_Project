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
public class CustomerChangeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("nameUser");
        String password = request.getParameter("passUser");
        String email = request.getParameter("emailUser");
        String phone = request.getParameter("phoneUser");
        String role = request.getParameter("roleUser");
        String status = request.getParameter("statusUser");
        String id = request.getParameter("idUser");

        AdminManageUserService adminManageUserService = new AdminManageUserService();
        if(username != null && !username.isEmpty()){
            adminManageUserService.setName(id,username);
        }
        if(password != null && !password.isEmpty()){
            adminManageUserService.setPass(id,password);
        }
        if(email != null && !email.isEmpty()){
            if (adminManageUserService.checkEmail(email)){
                request.setAttribute("message", "Email đã tồn tại! vui lòng nhập email khác!");
                request.getRequestDispatcher("/Admin/customerChange_mng.jsp").forward(request, response);
                return;
            }else {
                
            }
        }
        if(phone != null && !phone.isEmpty()){

        }
        if(role != null && !role.isEmpty()){

        }
        if(status != null && !status.isEmpty()){

        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uId = request.getParameter("uId");
        int userId = Integer.parseInt(uId);
        AdminManageUserService adminManageUserService = new AdminManageUserService();
        User user = adminManageUserService.getUserById(uId);


        request.setAttribute("user", user);
        request.getRequestDispatcher("Admin/customerChange_mng.jsp").forward(request, response);
    }
}
