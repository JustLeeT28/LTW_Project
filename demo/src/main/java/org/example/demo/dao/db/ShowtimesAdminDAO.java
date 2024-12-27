package org.example.demo.dao.db;

import org.example.demo.dao.model.Showtime;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShowtimesAdminDAO {
    private Connection connection;

    public ShowtimesAdminDAO(Connection connection) {
        this.connection = connection;
    }

    // Lấy tất cả lịch chiếu
    public List<Showtime> getAllShowtimes() throws SQLException {
        List<Showtime> showtimesList = new ArrayList<>();
        String query = "SELECT * FROM showtimes";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Showtime showtime = new Showtime(
                        rs.getInt("id"),
                        rs.getInt("movieId"),
                        rs.getString("date"),
                        rs.getString("time"),
                        rs.getInt("roomId")
                );
                showtimesList.add(showtime);
            }
        }
        return showtimesList;
    }

    // Thêm lịch chiếu mới
    public void addShowtime(Showtime showtime) throws SQLException {
        String query = "INSERT INTO showtimes (movieId, roomId, date, time) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, showtime.getMovieId());
            stmt.setInt(2, showtime.getRoomId());
            stmt.setString(3, showtime.getDate());
            stmt.setString(4, showtime.getTime());
            stmt.executeUpdate();
        }
    }

    // Xóa lịch chiếu
    public void deleteShowtime(int id) throws SQLException {
        String query = "DELETE FROM showtimes WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}