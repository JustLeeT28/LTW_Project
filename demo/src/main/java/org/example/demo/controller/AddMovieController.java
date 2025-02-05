package org.example.demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.demo.dao.model.Movie;
import org.example.demo.dao.model.User;
import org.example.demo.service.AddMovieService;
import org.example.demo.service.MovieService;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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
        String trailer = request.getParameter("trailerUrl");

        String delMovie = request.getParameter("del_movie_id");

        AddMovieService addMovieService = new AddMovieService();
        if (title != null && !title.isEmpty() &&
                posterUrl != null && !posterUrl.isEmpty() &&
                bannerUrl != null && !bannerUrl.isEmpty() &&
                description != null && !description.isEmpty() &&
                country != null && !country.isEmpty() &&
                language != null && !language.isEmpty() &&
                subtitle != null && !subtitle.isEmpty() &&
                duration != null && !duration.isEmpty() &&
                genres != null && !genres.isEmpty() &&
                directors != null && !directors.isEmpty() &&
                actors != null && !actors.isEmpty() &&
                ageRating != null && !ageRating.isEmpty() &&
                releaseDate != null && !releaseDate.isEmpty() &&
                endDate != null && !endDate.isEmpty() &&
                trailer != null && !trailer.isEmpty()){
            // tao dữ liệu trong bảng movies
            int movie_newid = addMovieService.addMovie(title, posterUrl, bannerUrl, description, country, language, subtitle, ageRating, releaseDate, endDate, duration, trailer);
            if (movie_newid == -1) {
                request.setAttribute("Message", "Thêm phim không thành công!");
                doGet(request, response);
            }
            // tạo dữ liệu trong bảng genre_movie
            addMovieService.addGenre_movie(genres, movie_newid);

            addMovieService.addDirector_movie(directors, movie_newid);

            addMovieService.addActor_movie(actors, movie_newid);

            request.setAttribute("Message", "Thêm phim thành công!");
            doGet(request, response);
        }

        if(delMovie != null && !delMovie.isEmpty()) {
            addMovieService.delMovie(delMovie);
            request.setAttribute("Message", "Xóa phim thành công!");
            doGet(request, response);
        }

        doGet(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isAdminLoggedIn(request)) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // Trả về lỗi 404
            return;
        }
        String query_movie = request.getParameter("query_movie");
        String updateMovieId = request.getParameter("update_movie_id");
        if(updateMovieId != null && !updateMovieId.isEmpty()) {
            request.setAttribute("mId", updateMovieId);
            request.getRequestDispatcher("/Admin/update_film_management.jsp").forward(request, response);
        }
        List<Movie> movies = new ArrayList<>(); // Sử dụng ArrayList để có thể gán sau này
        MovieService movieService = new MovieService();
        if(query_movie != null && !query_movie.isEmpty()) {
            movies = movieService.getMoviesByQuery(query_movie);
        }else {
            movies = movieService.getMoviesA_Z(); // Lấy danh sách phim từ service
        }
        request.setAttribute("movies", movies); // Lưu vào request để hiển thị lên JSP

        request.getRequestDispatcher("/Admin/film_management.jsp").forward(request, response); // Chuyển tới trang film_management.jsp
    }
    private boolean isAdminLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Lấy session (không tạo mới)
        if (session == null) return false;

        // Lấy thông tin role từ session
        User u = (User) session.getAttribute("user");
        return u != null && u.getRole() == 1; // Kiểm tra quyền là admin (1)
    }

}