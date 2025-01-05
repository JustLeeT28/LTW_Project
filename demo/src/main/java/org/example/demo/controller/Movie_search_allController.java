package org.example.demo.controller;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.demo.dao.model.Movie;
import org.example.demo.service.MovieService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Movie_search_allController", urlPatterns = "/search")

public class Movie_search_allController extends HttpServlet {
    private static final int RECORDS_PER_PAGE = 8; // Số sản phẩm mỗi trang
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("query"); // Dùng cho tìm kiếm
        String pageParam = request.getParameter("page");
        String genre = request.getParameter("genre");

        int currentPage = (pageParam == null || pageParam.isEmpty()) ? 1 : Integer.parseInt(pageParam);
        MovieService movieService = new MovieService();
        List<Movie> movies;
        if (genre != null && !genre.isEmpty()) {
             movies = movieService.getGenreMovies(genre);
        } else {
             movies = movieService.getMovies();
        }
        // Tính toán số lượng trang
        int totalRecords = movies.size();
        int totalPages = (int) Math.ceil((double) totalRecords / RECORDS_PER_PAGE);

        // Lấy sản phẩm của trang hiện tại
        int startIndex = (currentPage - 1) * RECORDS_PER_PAGE;
        int endIndex = Math.min(startIndex + RECORDS_PER_PAGE, totalRecords);
        List<Movie> moviesOnPage = movies.subList(startIndex, endIndex); // Chỉ lấy sản phẩm cho trang hiện tại

        // Đặt thông tin vào request
        request.setAttribute("movies_all", moviesOnPage);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", currentPage);
//        request.setAttribute("movies_all", movies);
        request.getRequestDispatcher("Pages/Search.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}