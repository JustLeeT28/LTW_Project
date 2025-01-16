package org.example.demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.demo.dao.MovieDao;
import org.example.demo.dao.model.Movie;
import org.example.demo.dao.model.User;
import org.example.demo.service.UpdateMovieService;
import org.example.demo.service.UserService;

import java.io.IOException;

@WebServlet(name = "Update_Fil_Controller", urlPatterns = {"/UpdateFilm"})
public class UpdateFilmController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        // Lấy dữ liệu từ form
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

        int movieId = Integer.parseInt(request.getParameter("mId"));

        int count = 0;
        UpdateMovieService updateMovieService = new UpdateMovieService();
        if (title != null && !title.isEmpty()) {
            updateMovieService.updateTitle(movieId, title);
            count++;
        }

        if (posterUrl != null && !posterUrl.isEmpty()) {
            updateMovieService.updatePosterUrl(movieId, posterUrl);
            count++;
        }

        if (bannerUrl != null && !bannerUrl.isEmpty()) {
            updateMovieService.updateBannerUrl(movieId, bannerUrl);
            count++;
        }

        if (description != null && !description.isEmpty()) {
            updateMovieService.updateDescription(movieId, description);
            count++;
        }

        if (country != null && !country.isEmpty()) {
            updateMovieService.updateCountry(movieId, country);
            count++;
        }

        if (language != null && !language.isEmpty()) {
            updateMovieService.updateLanguage(movieId, language);
            count++;
        }

        if (subtitle != null && !subtitle.isEmpty()) {
            updateMovieService.updateSubtitle(movieId, subtitle);
            count++;
        }

        if (duration != null && !duration.isEmpty()) {
            updateMovieService.updateDuration(movieId, duration);
            count++;
        }

        if (genres != null && !genres.isEmpty()) {
            updateMovieService.updateGenres(movieId, genres);
            count++;
        }

        if (directors != null && !directors.isEmpty()) {
            updateMovieService.updateDirectors(movieId, directors);
            count++;
        }

        if (actors != null && !actors.isEmpty()) {
            updateMovieService.updateActors(movieId, actors);
            count++;
        }

        if (ageRating != null && !ageRating.isEmpty()) {
            updateMovieService.updateAgeRating(movieId, ageRating);
            count++;
        }

        if (releaseDate != null && !releaseDate.isEmpty()) {
            updateMovieService.updateReleaseDate(movieId, releaseDate);
            count++;
        }

        if (endDate != null && !endDate.isEmpty()) {
            updateMovieService.updateEndDate(movieId, endDate);
            count++;
        }
        // Kiểm tra xem có ít nhất một thay đổi nào không
        if (count > 0) {
            // Cập nhật thành công
            response.sendRedirect("film_management");  // Ví dụ sau khi cập nhật xong, quay lại danh sách phim
        } else {
            // Không có thay đổi nào
            request.setAttribute("Message", "Không có thông tin cần cập nhật.");
            request.setAttribute("movie_id", movieId);
            request.getRequestDispatcher("/Admin/update_film_management.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isAdminLoggedIn(request)) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // Trả về lỗi 404
            return;
        }
        int movieId = Integer.parseInt(request.getParameter("mId"));
        MovieDao movieDao = new MovieDao();
        Movie m =  movieDao.getMovieById(movieId);
        String movieTitle = m.getTitle();
        request.setAttribute("movie_id", movieId);
        request.setAttribute("movie_title", movieTitle);
        request.getRequestDispatcher("/Admin/update_film_management.jsp").forward(request, response);

    }
    private boolean isAdminLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Lấy session (không tạo mới)
        if (session == null) return false;

        // Lấy thông tin role từ session
        User u = (User) session.getAttribute("user");
        return u != null && u.getRole() == 1; // Kiểm tra quyền là admin (1)
    }
}