package org.example.demo.dao;

import org.example.demo.dao.db.DbConnect;
import org.example.demo.dao.model.Movie;
import org.example.demo.dao.model.Seat;
import org.example.demo.dao.model.ShowSeat;
import org.example.demo.dao.model.Showtime;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDao {
//    lấy ra danh sách lịch chiếu của phòng đó trong ngày
    public List<Showtime> getScheduleByDay_Room (String day, String room) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Showtime> listShowtimes = new ArrayList<>();
        try {
            String query = "SELECT * FROM showtimes WHERE roomId = ? AND showDate = ?";
            ps = DbConnect.get(query);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = sdf.parse(day);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            ps.setString(1,room);
            ps.setDate(2,sqlDate);
            rs = ps.executeQuery();
            while (rs.next()) {
                Showtime showtime = new Showtime(
                        rs.getInt("movieId"),
                        rs.getInt("roomId"),
                        rs.getDate("showDate").toLocalDate(),
                        rs.getTime("showTime").toLocalTime(),
                        rs.getString("status")
                );
                listShowtimes.add(showtime);
            }
            return listShowtimes;
        } catch (ParseException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isInTime1(String currentTime, LocalTime startTime, int endTimeMinutes) {
        // Định dạng giờ phút giây
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        // Chuyển đổi các chuỗi thời gian thành đối tượng LocalTime
        LocalTime current = LocalTime.parse(currentTime, timeFormatter);
//        LocalTime start = LocalTime.parse(startTime, timeFormatter);
        // Tính thời gian kết thúc bằng cách thêm số phút vào startTime
        LocalTime calculatedEndTime = startTime.plusMinutes(endTimeMinutes);
        // Kiểm tra xem currentTime có nằm trong khoảng từ startTime đến calculatedEndTime
        return (current.equals(startTime) || current.isAfter(startTime)) && current.isBefore(calculatedEndTime);
    }
    public boolean isInTime2(LocalTime timeShow, String startCurrentTime, int endTimeMinutes) {
        // Định dạng giờ phút giây
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        // Chuyển đổi các chuỗi thời gian thành đối tượng LocalTime
        LocalTime current = LocalTime.parse(startCurrentTime, timeFormatter);
//        LocalTime start = LocalTime.parse(startTime, timeFormatter);
        // Tính thời gian kết thúc bằng cách thêm số phút vào startTime
        LocalTime calculatedEndTime = current.plusMinutes(endTimeMinutes); // + với thời gian phim chiếu
        // Kiểm tra xem currentTime có nằm trong khoảng từ startTime đến calculatedEndTime
        return (timeShow.equals(current) || timeShow.isAfter(current)) && timeShow.isBefore(calculatedEndTime);
    }


    public boolean timeIsBefore(LocalTime one, String two) {
        // Định dạng chuỗi thời gian theo kiểu "HH:mm:ss"
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        // Chuyển chuỗi `two` thành đối tượng LocalTime
        LocalTime timeTwo = LocalTime.parse(two, timeFormatter);
        // Sử dụng isBefore để kiểm tra `one` có trước `timeTwo` hay không
        return one.isBefore(timeTwo);
    }


    public boolean isConflict(String movieId,String roomId, String showDate, String showTime) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int mid = Integer.parseInt(movieId);
        MovieDao movieDao = new MovieDao();
        Movie currentMovie = movieDao.getMovieById(mid); // để lấy thời gian phim hiện tại
        // lay danh sach phim của phòng trong ngày
        List<Showtime> ListShowtimesInDay = getScheduleByDay_Room(showDate, roomId);
        for (Showtime s : ListShowtimesInDay) {
            Movie movieInDayofRoom = movieDao.getMovieById(s.getMovieId());
            if (timeIsBefore(s.getShowTime(), showTime)) { // showTime này có trc showtime sắp thêm k
                if (isInTime1(showTime, s.getShowTime(), movieInDayofRoom.getDuration())) {
                    return true; // phim bị trùng h với phim trước
                } else {
                    continue;
                }
            } else { // showTime này có sau showtime sắp thêm k
                if (isInTime2(s.getShowTime(), showTime, currentMovie.getDuration())) {
                    return true; // phim bị trùng lịch với phim sau
                } else {
                    continue;
                }
            }
        }
        return false; // k bị trùng
    }


    public static List<Seat> GetSeatByRoom(String roomId) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int roomid = Integer.parseInt(roomId);
        List<Seat> listSeats = new ArrayList<>();
        try {
            String query = "SELECT * FROM seats WHERE roomId = ?";
            ps = DbConnect.get(query);
            ps.setInt(1,roomid);
            rs = ps.executeQuery();
            while (rs.next()) {
                // Khởi tạo đối tượng Seat từ dữ liệu trong ResultSet
                Seat seat = new Seat(
                        rs.getInt("id"),           // ID của ghế
                        rs.getInt("roomId"),       // ID của phòng
                        rs.getString("row"),       // Hàng ghế
                        rs.getString("seat_number"),// Số ghế
                        rs.getDouble("price"),     // Giá của ghế
                        rs.getString("status")   // Trạng thái ghế (active/inactive)
                );
                // Thêm ghế vào danh sách
                listSeats.add(seat);
            }
            return listSeats;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void addShow_seats(int showid, int seatId,String seatStatus) {
        PreparedStatement ps = null;
        String st_sStatus ;
        if (seatStatus.equals("active")) {
            st_sStatus = "available";  // Ghế active sẽ là available
        } else if (seatStatus.equals("inactive")) {
            st_sStatus = "booked";  // Ghế inactive sẽ là booked
        } else {
            st_sStatus = "available";  // Ghế active sẽ là available
        }
        try {
            String query = "INSERT INTO showtime_seats(showTimeId,seatId,status) VALUES(?,?,?)";
            ps = DbConnect.get(query);
            ps.setInt(1,showid);
            ps.setInt(2,seatId);
            ps.setString(3,st_sStatus);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public void addShowAndSeats(int showid, String roomId) {
//        List<Seat> listSeats = GetSeatByRoom(roomId);
//        for (Seat s : listSeats) {
//            addShow_seats(showid,s.getId(),s.getIsActive());
//        }
//    }

    public void addShowTime(String movieId, String roomId, String showDate, String showTime) {
        PreparedStatement ps = null;
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            // Chuyển đổi chuỗi sang LocalDate và LocalTime
            LocalDate localShowDate = LocalDate.parse(showDate, dateFormatter);
            LocalTime localShowTime = LocalTime.parse(showTime, timeFormatter);

            // Câu truy vấn SQL để thêm mới thời gian chiếu
            String query = "INSERT INTO showtimes (movieId, roomId, showDate, showTime) VALUES (?, ?, ?, ?)";

            // Kết nối đến cơ sở dữ liệu và thiết lập PreparedStatement
            ps = DbConnect.get(query); // Giả sử DbConnect.get(query) sẽ trả về PreparedStatement

            // Gán giá trị cho các tham số của PreparedStatement
            ps.setInt(1, Integer.parseInt(movieId)); // set movieId
            ps.setInt(2, Integer.parseInt(roomId)); // set roomId
            ps.setDate(3, Date.valueOf(localShowDate)); // set showDate (LocalDate) -> Date
            ps.setTime(4, Time.valueOf(localShowTime)); // set showTime (LocalTime) -> Time

            // Thực hiện câu truy vấn
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Showtime GetShowTime(int movieId, int roomId, LocalDate showDate, LocalTime showTime) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM showtimes WHERE movieId = ? AND roomId = ? AND showDate = ? AND showTime = ? ";
            ps = DbConnect.get(query);
            ps.setInt(1,movieId);
            ps.setInt(2,roomId);
            ps.setDate(3,Date.valueOf(showDate));
            ps.setTime(4,Time.valueOf(showTime));
            rs = ps.executeQuery();
            if (rs.next()) {
                Showtime s = new Showtime(
                        rs.getInt("id"),
                        rs.getInt("movieId"),
                        rs.getInt("roomId"),
                        rs.getDate("showDate").toLocalDate(),
                        rs.getTime("showTime").toLocalTime(),
                        rs.getString("status")
                );
                return s;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ShowSeat> GetShowSeatByshowID(int showId) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ShowSeat> listSeats = new ArrayList<>();
        try{
            String query = "SELECT * FROM showtime_seats WHERE showTimeId = ?";
            ps = DbConnect.get(query);
            ps.setInt(1,showId);
            rs = ps.executeQuery();
            while (rs.next()) {
                ShowSeat seat = new ShowSeat(
                        rs.getInt("id"),
                        rs.getInt("showTimeId"),
                        rs.getInt("seatId"),
                        rs.getString("status")
                );
                listSeats.add(seat);
            }
            return listSeats;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public static void main(String[] args) {
//        ScheduleDao scheduleDao = new ScheduleDao();
//        Showtime showtime = scheduleDao.GetShowTime(1,5,2025-01-01,12:30:00);
//        scheduleDao.addShowAndSeats(1,"5");
//        List<ShowSeat> showSeats = scheduleDao.GetShowSeatByshowID(1);
//        for (ShowSeat s : showSeats) {
//            System.out.println(s);
//        }
//    }
}
