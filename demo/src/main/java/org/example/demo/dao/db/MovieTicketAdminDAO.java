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

    public List<MovieTicket> getAllTickets() {
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

    public boolean addTicket(MovieTicket ticket) {
        String query = "INSERT INTO movie_tickets (orderId, showTimeId, seatId, price, created_at) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, ticket.getOrderId());
            stmt.setInt(2, ticket.getShowTimeId());
            stmt.setInt(3, ticket.getSeatId());
            stmt.setDouble(4, ticket.getPrice());
            stmt.setString(5, ticket.getCreatedAt());

            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteTicket(int id) {
        String query = "DELETE FROM movie_tickets WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateTicket(MovieTicket ticket) {
        String query = "UPDATE movie_tickets SET orderId = ?, showTimeId = ?, seatId = ?, price = ?, created_at = ? " +
                "WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, ticket.getOrderId());
            stmt.setInt(2, ticket.getShowTimeId());
            stmt.setInt(3, ticket.getSeatId());
            stmt.setDouble(4, ticket.getPrice());
            stmt.setString(5, ticket.getCreatedAt());
            stmt.setInt(6, ticket.getId());

            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public MovieTicket getTicketById(int id) {
        String query = "SELECT mt.id, mt.orderId, mt.showTimeId, mt.seatId, mt.price, mt.created_at, " +
                "u.name AS customerName, " +
                "CONCAT(s.row, s.seat_number) AS seat, " +
                "CONCAT(sh.showDate, ' ', sh.showTime) AS showtime " +
                "FROM movie_tickets mt " +
                "JOIN orders o ON mt.orderId = o.id " +
                "JOIN users u ON o.userId = u.id " +
                "JOIN seats s ON mt.seatId = s.id " +
                "JOIN showtimes sh ON mt.showTimeId = sh.id " +
                "WHERE mt.id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new MovieTicket(
                        rs.getInt("id"),
                        rs.getInt("orderId"),
                        rs.getInt("showTimeId"),
                        rs.getInt("seatId"),
                        rs.getDouble("price"),
                        rs.getString("created_at"),
                        rs.getString("customerName"),
                        rs.getString("seat"),
                        rs.getString("showtime")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
