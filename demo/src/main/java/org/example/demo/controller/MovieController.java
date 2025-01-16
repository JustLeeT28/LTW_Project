package org.example.demo.controller;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.demo.dao.model.Movie;
import org.example.demo.service.MovieService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "MovieController", urlPatterns = "")

public class MovieController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MovieService movieService = new MovieService();
        List<Movie> movies = movieService.getMovies();
        request.setAttribute("movies", movies);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}