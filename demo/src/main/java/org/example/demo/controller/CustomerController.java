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
        String query_cus = request.getParameter("query_customers");
        String idStatusBlock = request.getParameter("userId_status_block");
        String idStatusUnblock = request.getParameter("userId_status_unblock");
        String idUserdel = request.getParameter("userId_del");
        Customer_mng_Service service = new Customer_mng_Service();
        // vô hiệu hóa tài khoản
        if (idStatusBlock != null && !idStatusBlock.isEmpty()) {
            service.blockCustomer(Integer.parseInt(idStatusBlock));
        }
        // gỡ vô hiệu hóa tài khoản
        if (idStatusUnblock != null && !idStatusUnblock.isEmpty()) {
            service.unBlockCustomer(Integer.parseInt(idStatusUnblock));
        }
        if (idUserdel != null && !idUserdel.isEmpty()) {
            service.delCustomer(Integer.parseInt(idUserdel));
        }
        List<User> listUser = new ArrayList<User>();
        if (query_cus != null && !query_cus.isEmpty()) {
            listUser = service.getCustomer(query_cus);
        } else{
            listUser = service.getAllUser();
        }


//        request.setAttribute("date", date);
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("/Admin/customer_mng.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}