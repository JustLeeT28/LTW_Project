package org.example.demo.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.demo.dao.model.Actor;
import org.example.demo.dao.model.Director;
import org.example.demo.dao.model.Movie;
import org.example.demo.dao.model.Showtime;
import org.example.demo.service.MovieService;
import org.example.demo.service.ShowtimeService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookController", urlPatterns = "/book")
public class BookController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy 'id' từ query parameter trong URL
        String movieId = request.getParameter("mId");
        MovieService movieService = new MovieService();
        ShowtimeService showtimeService = new ShowtimeService();

        // Lấy thông tin phim
        Movie movie = movieService.getMovieById(Integer.parseInt(movieId));
        List<Actor> actors = movieService.getActors(movie.getId());
        List<Director> directors = movieService.getDirectors(movie.getId());

        // Lấy tất cả các showtime của phim
        List<Showtime> showtimes = showtimeService.getShowTime(movie.getId());
        List<Showtime> showtimesSameDate = showtimeService.getShowTimeSameDate(movie.getId());

        // Gửi thông tin phim, diễn viên, đạo diễn và showtime cho JSP



        // Kiểm tra nếu có tham số ngày và tháng trong URL
        String day = request.getParameter("day"); // Tham số 'day' trong URL
        String month = request.getParameter("month"); // Tham số 'month' trong URL

        if (day != null && !day.isEmpty() && month != null && !month.isEmpty()) {
            // Nếu có tham số ngày và tháng, lọc showtime theo ngày và tháng
            List<Showtime> showtimesByDateAndId = showtimeService.getShowTimeByDateAndId(movie.getId(), day, month);
            request.setAttribute("showtimesByDateAndId", showtimesByDateAndId);
        }

        String hour = request.getParameter("hour");
        String minute = request.getParameter("minute");

        if (hour != null && !hour.isEmpty() && minute != null && !minute.isEmpty() && day != null && !day.isEmpty() && month != null && !month.isEmpty()) {
//            List<Showtime> showtimesByTimeAndId = showtimeService.getShowTimeByTimeAndId(movie.getId(), hour, minute);
//            request.setAttribute("showtimesByTimeAndId", showtimesByTimeAndId);

        }
        request.setAttribute("date", day);
        request.setAttribute("month", month);
        request.setAttribute("movie", movie);
        request.setAttribute("actors", actors);
        request.setAttribute("directors", directors);
        request.setAttribute("showtimes", showtimes);
        request.setAttribute("showtimesSameDate", showtimesSameDate);
        request.setAttribute("hour", hour);
        request.setAttribute("minute", minute);
        // Chuyển hướng tới trang book.jsp
        request.getRequestDispatcher("Pages/book.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Bạn có thể xử lý POST ở đây nếu cần
    }
}
