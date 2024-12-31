package org.example.demo.dao.db;

import org.example.demo.dao.models.MovieTicket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieTicketAdminDAO {
    private Connection connection;

    public MovieTicketAdminDAO(Connection connection) {
        this.connection = connection;
    }

    // Lấy danh sách vé đã đặt
    public List<MovieTicket> getAllBookedTickets() throws SQLException {
        String query = """
            SELECT mt.id, mt.orderId, mt.showTimeId, mt.seatId, mt.price, mt.created_at,
                   u.name AS customerName, s.row || s.seat_number AS seat,
                   sh.showDate || ' ' || sh.showTime AS showtime
            FROM movie_tickets mt
            JOIN orders o ON mt.orderId = o.id
            JOIN users u ON o.userId = u.id
            JOIN seats s ON mt.seatId = s.id
            JOIN showtimes sh ON mt.showTimeId = sh.id
        """;
        List<MovieTicket> tickets = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                tickets.add(new MovieTicket(
                        rs.getInt("id"),
                        rs.getInt("orderId"),
                        rs.getInt("showTimeId"),
                        rs.getInt("seatId"),
                        rs.getDouble("price"),
                        rs.getString("created_at"),
                        rs.getString("customerName"),
                        rs.getString("seat"),
                        rs.getString("showtime")
                ));
            }
        }
        return tickets;
    }

    // Tìm kiếm vé
    public List<MovieTicket> searchTickets(String keyword) throws SQLException {
        String query = """
            SELECT mt.id, mt.orderId, mt.showTimeId, mt.seatId, mt.price, mt.created_at,
                   u.name AS customerName, s.row || s.seat_number AS seat,
                   sh.showDate || ' ' || sh.showTime AS showtime
            FROM movie_tickets mt
            JOIN orders o ON mt.orderId = o.id
            JOIN users u ON o.userId = u.id
            JOIN seats s ON mt.seatId = s.id
            JOIN showtimes sh ON mt.showTimeId = sh.id
            WHERE u.name LIKE ? OR CAST(mt.id AS CHAR) LIKE ? OR sh.showDate || ' ' || sh.showTime LIKE ?
        """;
        List<MovieTicket> tickets = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            String pattern = "%" + keyword + "%";
            statement.setString(1, pattern);
            statement.setString(2, pattern);
            statement.setString(3, pattern);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    tickets.add(new MovieTicket(
                            rs.getInt("id"),
                            rs.getInt("orderId"),
                            rs.getInt("showTimeId"),
                            rs.getInt("seatId"),
                            rs.getDouble("price"),
                            rs.getString("created_at"),
                            rs.getString("customerName"),
                            rs.getString("seat"),
                            rs.getString("showtime")
                    ));
                }
            }
        }
        return tickets;
    }
}

