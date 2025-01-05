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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MovieService movieService = new MovieService();
        List<Movie> movies = movieService.getMovies();
        request.setAttribute("movies_all", movies);
        request.getRequestDispatcher("Pages/Search.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}