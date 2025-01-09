package org.example.demo.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.demo.dao.model.Actor;
import org.example.demo.dao.model.Director;
import org.example.demo.dao.model.Movie;
import org.example.demo.service.MovieService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookController", urlPatterns = "/book")
public class BookController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy 'id' từ query parameter trong URL
        String movieId = request.getParameter("mId");
        MovieService movieService = new MovieService();
        Movie movie = movieService.getMovieById(Integer.parseInt(movieId));
        List<Actor> actors = movieService.getActors(movie.getId());
        List<Director> directors = movieService.getDirectors(movie.getId());
        request.setAttribute("movie", movie);
        request.setAttribute("actors", actors);
        request.setAttribute("directors", directors);


        // Chuyển hướng tới trang book.jsp
        request.getRequestDispatcher("Pages/book.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Bạn có thể xử lý POST ở đây nếu cần
    }
}
