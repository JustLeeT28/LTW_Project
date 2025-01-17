package org.example.demo.dao;

import org.example.demo.dao.db.DbConnect;
import org.example.demo.dao.model.Seat;
import org.example.demo.dao.model.ShowSeat;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SeatDao {
    public List<Seat> getSeatsInRoom(int roomId) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM seats WHERE roomId = ?";

            ps = DbConnect.get(query); // Lấy PreparedStatement từ DbConnect
            ps.setInt(1, roomId); // Set tham số cho PreparedStatement
            resultSet = ps.executeQuery(); // Thực thi truy vấn

            List<Seat> seats = new ArrayList<>();
            while (resultSet.next()) {
                Seat movie = new Seat(
                        resultSet.getInt("id"),
                        resultSet.getInt("roomId"),
                        resultSet.getString("row"),
                        resultSet.getString("seat_number"),
                        resultSet.getDouble("price"),
                        resultSet.getString("isActive")
                );
                seats.add(movie);
            }

            return seats;

        } catch (SQLException e) {
            e.printStackTrace(); // Log lỗi
            return new ArrayList<>(); // Trả về danh sách rỗng khi gặp lỗi
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Log lỗi khi đóng tài nguyên
            }
        }
    }

    public List<ShowSeat> getStatusSeatByShowtimeId(int showtimeId, int roomId) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM showtime_seats WHERE showtimeId = ? AND roomId = ?";

            ps = DbConnect.get(query); // Lấy PreparedStatement từ DbConnect
            ps.setInt(1, showtimeId); // Set tham số cho PreparedStatement
            ps.setInt(2, roomId);
            resultSet = ps.executeQuery(); // Thực thi truy vấn
            List<ShowSeat> seats = new ArrayList<>();
            while (resultSet.next()) {
                ShowSeat movie = new ShowSeat(
                        resultSet.getInt("id"),
                        resultSet.getInt("showtimeId"),
                        resultSet.getInt("seatId"),
                        resultSet.getString("status"),
                        resultSet.getInt("roomId")
                );
                seats.add(movie);
            }

            return seats;

        } catch (SQLException e) {
            e.printStackTrace(); // Log lỗi
            return new ArrayList<>(); // Trả về danh sách rỗng khi gặp lỗi
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Log lỗi khi đóng tài nguyên
            }
        }
    }

    public Set<String> getRowInRoom(int roomId) {
        List<Seat> seats = getSeatsInRoom(roomId);
        Set<String> rows = new HashSet<>();
        for (Seat seat : seats) {
            rows.add(seat.getRow());
        }
        return rows;
    }


    public Seat getSeatById(int seatId) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM seats WHERE id = ?";

            ps = DbConnect.get(query); // Lấy PreparedStatement từ DbConnect
            ps.setInt(1, seatId); // Set tham số cho PreparedStatement
            resultSet = ps.executeQuery(); // Thực thi truy vấn

            if (resultSet.next()) {
                Seat seat = new Seat(
                        resultSet.getInt("id"),
                        resultSet.getInt("roomId"),
                        resultSet.getString("row"),
                        resultSet.getString("seat_number"),
                        resultSet.getDouble("price"),
                        resultSet.getString("isActive")
                );
                return seat;
            }

            return null;

        } catch (SQLException e) {
            e.printStackTrace(); // Log lỗi
            return null; // Trả về danh sách rỗng khi gặp lỗi
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Log lỗi khi đóng tài nguyên
            }
        }
    }
    public void setStatus(String status, int seatId,int showtimeId) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "UPDATE showtime_seats SET status = ? WHERE seatId = ? AND showtimeId = ?";
            ps = DbConnect.get(query);  // Lấy PreparedStatement từ DbConnect
            ps.setString(1, status);
            ps.setInt(2, seatId);
            ps.setInt(3, showtimeId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        SeatDao seatDao = new SeatDao();
            List<ShowSeat> statusSeatByShowtimeId = seatDao.getStatusSeatByShowtimeId(36, 2);
            for (ShowSeat showSeat : statusSeatByShowtimeId) {
                System.out.print(showSeat.getId());
                System.out.print(showSeat.getStatus());
        }
    }

}
