package org.example.demo.controller;

import org.example.demo.model.Movies;
import org.example.demo.service.MoviesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/movies")
public class MoviesServlet extends HttpServlet {
    private final MoviesService moviesService = new MoviesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Movies> movies = moviesService.getMovies();
        req.setAttribute("movies", movies);
        req.getRequestDispatcher("/film_management.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String genre = req.getParameter("genre");
        int duration = Integer.parseInt(req.getParameter("duration"));
        String releaseDate = req.getParameter("releaseDate");
        String endDate = req.getParameter("endDate");
        String ageRating = req.getParameter("ageRating");
        String bannerUrl = req.getParameter("bannerUrl");
        String posterUrl = req.getParameter("posterUrl");
        Movies movie = new Movies(posterUrl, bannerUrl, endDate, releaseDate, ageRating, genre, description, null, duration, null, title, 0);
        boolean isAdded = moviesService.addMovie(movie);
        resp.sendRedirect("/movies");
    }
}
