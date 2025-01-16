package org.example.demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.service.TikketPriceService;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

@WebServlet(name = "tikketPrice_Controller", urlPatterns = "/tickketPrice")
public class TikketPriceController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TikketPriceService tikketPriceService = new TikketPriceService();

        int price2D = tikketPriceService.getPrice("2D");
        int price3D = tikketPriceService.getPrice("3D");
        int price4D = tikketPriceService.getPrice("4Dx");
        int priceImax = tikketPriceService.getPrice("Imax");

        NumberFormat formatter = NumberFormat.getInstance(Locale.US);
        String formattprice2D = formatter.format(price2D);
        String formattprice3D = formatter.format(price3D);
        String formattprice4D = formatter.format(price4D);
        String formattpriceImax = formatter.format(priceImax);

        request.setAttribute("price2D", formattprice2D);
        request.setAttribute("price3D", formattprice3D);
        request.setAttribute("price4D", formattprice4D);
        request.setAttribute("priceImax", formattpriceImax);

        request.getRequestDispatcher("/Pages/ticket-price.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

}
