package org.example.demo.dao.db;

import org.example.demo.dao.models.MovieTicket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MovieTicketAdminDAO {
    private Connection connection;

    public MovieTicketAdminDAO(Connection connection) {
        this.connection = connection;
    }

    public List<MovieTicket> getAllBookedTickets() {
        List<MovieTicket> tickets = new ArrayList<>();
        String query = "SELECT mt.id, mt.orderId, mt.showTimeId, mt.seatId, mt.price, mt.created_at, " +
                "u.name AS customerName, " +
                "CONCAT(s.row, s.seat_number) AS seat, " +
                "CONCAT(sh.showDate, ' ', sh.showTime) AS showtime " +
                "FROM movie_tickets mt " +
                "JOIN orders o ON mt.orderId = o.id " +
                "JOIN users u ON o.userId = u.id " +
                "JOIN seats s ON mt.seatId = s.id " +
                "JOIN showtimes sh ON mt.showTimeId = sh.id";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tickets;
    }

    public List<MovieTicket> searchTickets(String keyword) {
        List<MovieTicket> tickets = new ArrayList<>();
        String query = "SELECT mt.id, mt.orderId, mt.showTimeId, mt.seatId, mt.price, mt.created_at, " +
                "u.name AS customerName, " +
                "CONCAT(s.row, s.seat_number) AS seat, " +
                "CONCAT(sh.showDate, ' ', sh.showTime) AS showtime " +
                "FROM movie_tickets mt " +
                "JOIN orders o ON mt.orderId = o.id " +
                "JOIN users u ON o.userId = u.id " +
                "JOIN seats s ON mt.seatId = s.id " +
                "JOIN showtimes sh ON mt.showTimeId = sh.id " +
                "WHERE u.name LIKE ? OR mt.id LIKE ? OR CONCAT(sh.showDate, ' ', sh.showTime) LIKE ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            String searchPattern = "%" + keyword + "%";
            stmt.setString(1, searchPattern);
            stmt.setString(2, searchPattern);
            stmt.setString(3, searchPattern);

            ResultSet rs = stmt.executeQuery();
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tickets;
    }
}
