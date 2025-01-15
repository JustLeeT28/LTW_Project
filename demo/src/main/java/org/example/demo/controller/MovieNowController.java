package org.example.demo.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.dao.model.Genre;
import org.example.demo.dao.model.Movie;
import org.example.demo.service.MovieService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "MovieNowController", urlPatterns = "/movieNow")

public class MovieNowController extends HttpServlet {
    private static final int RECORDS_PER_PAGE = 8; // Số sản phẩm mỗi trang

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageParam = request.getParameter("page");
        int currentPage = (pageParam == null || pageParam.isEmpty()) ? 1 : Integer.parseInt(pageParam);
        MovieService movieService = new MovieService();
        List<Movie> movies = List.of();
        movies = movieService.getMovieNow();
        // Tính toán số lượng trang
        int totalRecords = movies.size();
        int totalPages = (int) Math.ceil((double) totalRecords / RECORDS_PER_PAGE);

        // Lấy sản phẩm của trang hiện tại
        int startIndex = Math.max(0, (currentPage - 1) * RECORDS_PER_PAGE);
        int endIndex = Math.min(startIndex + RECORDS_PER_PAGE, totalRecords);
        List<Movie> moviesOnPage = movies.subList(startIndex, endIndex); // Chỉ lấy sản phẩm cho trang hiện tại

        request.setAttribute("movies_now", moviesOnPage);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", currentPage);
        request.getRequestDispatcher("Pages/movie-show-now.jsp").forward(request, response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
