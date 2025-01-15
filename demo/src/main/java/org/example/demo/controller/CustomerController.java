package org.example.demo.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.service.DashboardService;


import java.io.IOException;
import java.util.List;

@WebServlet(name = "dashboardController", value = "/custome_mng")

public class CustomerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query_cus = request.getParameter("query_customer");

        DashboardService service = new DashboardService();

        double total_revenue = service.getTotalR7();


//        request.setAttribute("date", date);
        request.setAttribute("total_revenue", total_revenue);
        request.getRequestDispatcher("Admin/dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}