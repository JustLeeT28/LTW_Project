//package org.example.demo.controller;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.example.demo.dao.model.Movie;
//
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet("/movies")
//public class MoviesAdminServlet extends HttpServlet {
//    private final org.example.demo.service.MoviesAdminService moviesAdminService;
//
//    public MoviesAdminServlet() {
//        this.moviesAdminService = new org.example.demo.service.MoviesAdminService();
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Movie> movies = moviesAdminService.getAllMovies();
//        request.setAttribute("movieList", movies);
//        request.getRequestDispatcher("/film_management.jsp").forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//
//        if ("add".equals(action)) {
//            String title = request.getParameter("title");
//            int duration = Integer.parseInt(request.getParameter("duration"));
//            String description = request.getParameter("description");
//            String country = request.getParameter("country");
//            String language = request.getParameter("language");
//            String subtitle = request.getParameter("subtitle");
//            String ageRating = request.getParameter("ageRating");
//            String releaseDate = request.getParameter("releaseDate");
//            String endDate = request.getParameter("endDate");
//            String bannerUrl = request.getParameter("bannerUrl");
//            String posterUrl = request.getParameter("posterUrl");
//            String status = request.getParameter("status");
//
//            Movie movie = new Movie(0, title, duration, description, country, language, subtitle, ageRating, releaseDate, endDate, bannerUrl, posterUrl, status);
//            moviesAdminService.addMovie(movie);
//        } else if ("delete".equals(action)) {
//            int id = Integer.parseInt(request.getParameter("id"));
//            moviesAdminService.deleteMovie(id);
//        }
//
//        response.sendRedirect("movies");
//    }
//}
