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

    public static boolean isNumber(String queryCus) {
        String phoneRegex = "^[0-9]{1,15}$";
        return queryCus.matches(phoneRegex);
    }

    public boolean isConflict(String movieId,String roomId, String showDate, String showTime) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int mid = isNumber(movieId) ? Integer.parseInt(movieId) : getMovieId(movieId);
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


    public List<Seat> GetSeatByRoom(String roomId) {
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


//    public void addShow_seats(int showid, int seatId,String seatStatus, int roomId) {

//    public void addShow_seats(int showid, int seatId,String seatStatus) {
//        PreparedStatement ps = null;
//        String st_sStatus ;
//        if (seatStatus.equals("active")) {
//            st_sStatus = "seat";  // Ghế active sẽ là available
//        } else if (seatStatus.equals("inactive")) {
//            st_sStatus = "booked";  // Ghế inactive sẽ là booked
//        } else {
//            st_sStatus = "seat";
//        }
//        try {
//            String query = "INSERT INTO showtime_seats (showTimeId, seatId, status) VALUES(?,?,?)";
//            ps = DbConnect.get(query);
//            ps.setInt(1,showid);
//            ps.setInt(2,seatId);
//            ps.setString(3,st_sStatus);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public void addShow_seats(int showid, int seatId, String seatStatus,int roomid) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String st_sStatus;
        if (seatStatus.equals("active")) {
            st_sStatus = "seat";  // Ghế active sẽ là available
        } else if (seatStatus.equals("inactive")) {
            st_sStatus = "booked";  // Ghế inactive sẽ là booked
        } else {
            st_sStatus = "seat";  // Ghế active sẽ là available
        }
        try {
            // Kiểm tra xem cặp showTimeId và seatId đã tồn tại trong bảng showtime_seats chưa
            String checkQuery = "SELECT * FROM showtime_seats WHERE showTimeId = ? AND seatId = ?";
            ps = DbConnect.get(checkQuery);
            ps.setInt(1, showid);
            ps.setInt(2, seatId);
            rs = ps.executeQuery();
            if (!rs.next()) {  // Nếu không có bản ghi trùng lặp
                // Chèn dữ liệu mới
                String query = "INSERT INTO showtime_seats (showTimeId, seatId, status,roomId) VALUES(?,?,?,?)";
                ps = DbConnect.get(query);
                ps.setInt(1, showid);
                ps.setInt(2, seatId);
                ps.setString(3, st_sStatus);
                ps.setInt(4, roomid);

                ps.executeUpdate();
            } else {
                System.out.println("Ghế đã được chèn vào bảng showtime_seats rồi.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

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

    public int getMovieId(String MovieName) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        int movieId = -1;
        try {
            String query = "SELECT * FROM movies WHERE title LIKE ?";
            ps = DbConnect.get(query);  // Lấy PreparedStatement từ DbConnect

            ps.setString(1, MovieName);  // Set tham số cho PreparedStatement

            resultSet = ps.executeQuery();  // Thực thi truy vấn

            if (resultSet.next()) {
                 Movie m = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("duration"),
                        resultSet.getString("description"),
                        resultSet.getString("country"),
                        resultSet.getString("language"),
                        resultSet.getString("subtitle"),
                        resultSet.getString("ageRating"),
                        resultSet.getString("releaseDate"),
                        resultSet.getString("endDate"),
                        resultSet.getString("bannerUrl"),
                        resultSet.getString("posterUrl"),
                        resultSet.getString("status")
                );
                movieId = m.getId();
            }

            return movieId;  // Trả về null nếu không tìm thấy phim

        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi
            return movieId;  // Trả về null khi gặp lỗi
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();  // Log lỗi khi đóng tài nguyên
            }
        }
    }

    public void addShowTimeByName(String movieId, String roomId, String showDate, String showTime) {
        PreparedStatement ps = null;
        int movieid = getMovieId(movieId);
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
            ps.setInt(1, movieid); // set movieId
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

    public Showtime GetShowTimeByID(int showTimeID) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM showtimes WHERE id = ? ";
            ps = DbConnect.get(query);
            ps.setInt(1, showTimeID);
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

    public List<Showtime> getAllShowtime() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Showtime> listShowtimes = new ArrayList<>();
        try{
            String query = "SELECT * FROM showtimes " +
                    "ORDER BY id DESC";
            ps = DbConnect.get(query);
            rs = ps.executeQuery();
            while (rs.next()){
                Showtime s = new Showtime(
                        rs.getInt("id"),
                        rs.getInt("movieId"),
                        rs.getInt("roomId"),
                        rs.getDate("showDate").toLocalDate(),
                        rs.getTime("showTime").toLocalTime(),
                        rs.getString("status")
                );
                listShowtimes.add(s);
            }
            return listShowtimes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void dellShowtimeID(int showtimeID) {
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM showtimes WHERE id = ?";
            ps = DbConnect.get(sql);
            ps.setInt(1,showtimeID);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void del_show_seat(int showid, int seatid) {
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM showtime_seats WHERE showTimeId = ? AND seatId = ?";
            ps = DbConnect.get(sql);
            ps.setInt(1,showid);
            ps.setInt(2,seatid);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        ScheduleDao scheduleDao = new ScheduleDao();
//        ShowSeat sh = (ShowSeat) scheduleDao.GetShowSeatByshowID(2800);
        List<ShowSeat> showSeats = scheduleDao.GetShowSeatByshowID(23);
        for (ShowSeat showSeat : showSeats) {
            System.out.println(showSeat.getSeatId()+"--"+showSeat.getShowId()+"--"+showSeat.getRoomId());
        }


//        List<Seat> listseat = scheduleDao.GetSeatByRoom("1");
//        int cout = 0;
//        for (Seat seat : listseat) {
//            scheduleDao.addShow_seats(19,seat.getId(),seat.getIsActive());
//            scheduleDao.del_show_seat(22,seat.getId());
//            System.out.println(++cout + seat.getIsActive()+"--"+seat.getRoomId());
//        }

    }
}
