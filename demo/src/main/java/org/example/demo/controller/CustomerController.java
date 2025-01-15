package org.example.demo.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.dao.model.User;
import org.example.demo.service.Customer_mng_Service;
import org.example.demo.service.DashboardService;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "customersController", value = "/customer_mng")

public class CustomerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query_cus = request.getParameter("query_customer");
        String idStatusBlock  = request.getParameter("userId_status_block");
        Customer_mng_Service service = new Customer_mng_Service();
        if(idStatusBlock != null && !idStatusBlock.isEmpty()) {
            service.blockCustomer(Integer.parseInt(idStatusBlock));
        }
        List<User> listUser = new ArrayList<User>();
        listUser = service.getAllUser();


//        request.setAttribute("date", date);
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("/Admin/customer_mng.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}