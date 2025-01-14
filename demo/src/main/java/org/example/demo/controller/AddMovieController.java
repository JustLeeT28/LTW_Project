package org.example.demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.service.AddMovieService;


import java.io.IOException;


@WebServlet(name = "film_Controller", urlPatterns = "/film_management")
public class AddMovieController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String posterUrl = request.getParameter("posterUrl");
        String bannerUrl = request.getParameter("bannerUrl");
        String description = request.getParameter("description");
        String country = request.getParameter("country");
        String language = request.getParameter("language");
        String subtitle = request.getParameter("subtitle");
        String duration = request.getParameter("duration");
        String genres = request.getParameter("genre");
        String directors = request.getParameter("director");
        String actors = request.getParameter("actors");
        String ageRating = request.getParameter("ageRating");
        String releaseDate = request.getParameter("releaseDate");
        String endDate = request.getParameter("endDate");

        AddMovieService addMovieService = new AddMovieService();
        // tao dữ liệu trong bảng movies
        int movie_newid = addMovieService.addMovie(title,posterUrl,bannerUrl,description,country,language,subtitle,ageRating,releaseDate,endDate,duration);
        if (movie_newid == -1) {
            request.setAttribute("errorMessage", "Thêm phim không thành công!");
            request.getRequestDispatcher("/Admin/film_management.jsp").forward(request, response);
        }
        // tạo dữ liệu trong bảng genre_movie
        addMovieService.addGenre_movie(genres,movie_newid);

        addMovieService.addDirector_movie(directors,movie_newid);

        addMovieService.addActor_movie(actors,movie_newid);

        request.setAttribute("errorMessage", "Thêm thành công!");
        request.getRequestDispatcher("/Admin/film_management.jsp").forward(request, response);

        // Đăng ký
    }
}