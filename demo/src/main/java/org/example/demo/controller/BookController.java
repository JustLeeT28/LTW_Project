package org.example.demo.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.demo.dao.SeatDao;
import org.example.demo.dao.model.*;
import org.example.demo.service.MovieService;
import org.example.demo.service.SeatService;
import org.example.demo.service.ShowtimeService;

import javax.imageio.stream.ImageInputStream;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "BookController", urlPatterns = "/book")
public class BookController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy 'id' từ query parameter trong URL
        String movieId = request.getParameter("mId");
        String roomId = request.getParameter("roomId");
        String showtimeId = request.getParameter("showtimeId");
//        HttpSession session = request.getSession(false); // Lấy session hiện tại, nếu có




        Set<String> rowsInRoom = new HashSet<>();
        List<ShowSeat> statusSeatByShowtimeId = new ArrayList<>();
        List<ShowSeat> showSeats_status = new ArrayList<>();
        List<Seat> seatsInRoom =  new ArrayList<>();

        MovieService movieService = new MovieService();
        ShowtimeService showtimeService = new ShowtimeService();


        // Lấy thông tin phim
        Movie movie = movieService.getMovieById(Integer.parseInt(movieId));
        List<Actor> actors = movieService.getActors(movie.getId());
        List<Director> directors = movieService.getDirectors(movie.getId());

        // Lấy tất cả các showtime của phim
        List<Showtime> showtimes = showtimeService.getShowTime(movie.getId());
        List<Showtime> showtimesSameDate = showtimeService.getShowTimeSameDate(movie.getId());


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
        SeatService seatService = new SeatService();


        if (roomId != null && !roomId.isEmpty()  && showtimeId != null && !showtimeId.isEmpty() ) {
            statusSeatByShowtimeId = new SeatService().getStatusSeatByShowtimeId(Integer.parseInt(roomId), Integer.parseInt(showtimeId));
            seatsInRoom = new SeatService().getSeatsInRooms(Integer.parseInt(roomId));
            rowsInRoom = new SeatService().getRowsInRoom(Integer.parseInt(roomId));
            showSeats_status = seatService.getShow_Seat(roomId,showtimeId);

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
        request.setAttribute("roomId", roomId);
        request.setAttribute("showtimeId", showtimeId);
        request.setAttribute("statusSeats", statusSeatByShowtimeId );
        request.setAttribute("seatsInRoom", seatsInRoom);
        request.setAttribute("showSeats", showSeats_status);



        HttpSession session = request.getSession(false);
        List<Integer> selectedSeats = new ArrayList<>();

        if (session != null) {
            User user = (User) session.getAttribute("user");

            // Kiểm tra nếu session có "selectedSeats"
            List<String> seatStrings = (List<String>) session.getAttribute("selectedSeats");
            if (seatStrings != null) {
                // Chuyển đổi List<String> thành List<Integer>
                for (String seat : seatStrings) {
                    selectedSeats.add(Integer.parseInt(seat));
                }
            }
        }
        request.setAttribute("selectedSeats", selectedSeats);
        request.setAttribute("rowsInRoom", rowsInRoom);
        // Chuyển hướng tới trang book.jsp
        request.getRequestDispatcher("Pages/book.jsp").forward(request, response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Bạn có thể xử lý POST ở đây nếu cần
    }
}
