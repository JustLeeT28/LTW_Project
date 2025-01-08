package org.example.demo.dao.db;

import org.example.demo.dao.model.Showtime;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShowtimeAdminDAO {
    private Connection connection;

    public ShowtimeAdminDAO(Connection connection) {
        this.connection = connection;
    }

    // Lấy danh sách lịch chiếu
    public List<Showtime> getAllShowtimes() throws SQLException {
        String query = "SELECT * FROM showtimes";
        List<Showtime> showtimes = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                Showtime showtime = new Showtime(
                        rs.getInt("id"),
                        rs.getInt("movieId"),
                        rs.getString("movieTitle"),
                        rs.getInt("roomId"),
                        rs.getString("roomName"),
                        rs.getString("showDate"),
                        rs.getString("showTime"),
                        rs.getString("status")
                );
                showtimes.add(showtime);
            }
        }
        return showtimes;
    }

    // Thêm lịch chiếu
    public boolean addShowtime(Showtime showtime) throws SQLException {
        String query = "INSERT INTO showtimes (movieId, roomId, showDate, showTime, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, showtime.getMovieId());
            statement.setInt(2, showtime.getRoomId());
            statement.setString(3, showtime.getShowDate());
            statement.setString(4, showtime.getShowTime());
            statement.setString(5, showtime.getStatus());
            return statement.executeUpdate() > 0;
        }
    }

    // Xóa lịch chiếu
    public boolean deleteShowtime(int id) throws SQLException {
        String query = "DELETE FROM showtimes WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        }
    }

    // Cập nhật lịch chiếu
    public boolean updateShowtime(Showtime showtime) throws SQLException {
        String query = "UPDATE showtimes SET movieId = ?, roomId = ?, showDate = ?, showTime = ?, status = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, showtime.getMovieId());
            statement.setInt(2, showtime.getRoomId());
            statement.setString(3, showtime.getShowDate());
            statement.setString(4, showtime.getShowTime());
            statement.setString(5, showtime.getStatus());
            statement.setInt(6, showtime.getId());
            return statement.executeUpdate() > 0;
        }
    }
}
