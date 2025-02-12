package org.example.demo.dao;

import org.example.demo.dao.db.DbConnect;
import org.example.demo.dao.model.FoodTicketItem;
import org.example.demo.dao.model.MovieTickets;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDao {
    public void addMovieTicket(MovieTickets movieTickets) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "INSERT INTO movie_tickets (showtimeId, seatId, price, created_at, userId) VALUES (?, ?, ?, ?, ?)";
            ps = DbConnect.get(query);  // Lấy PreparedStatement từ DbConnect
            ps.setInt(1, movieTickets.getShowTimeId());
            ps.setInt(2, movieTickets.getSeatId());
            ps.setDouble(3, movieTickets.getPrice());
            ps.setString(4, movieTickets.getCreatedAt());
            ps.setInt(5, movieTickets.getUserId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addFoodTicketItem(FoodTicketItem foodTicketItem) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "INSERT INTO food_ticket_items (comboId, quantity, price, userId) VALUES (?, ?, ?, ?)";
            ps = DbConnect.get(query);  // Lấy PreparedStatement từ DbConnect
            ps.setInt(1, foodTicketItem.getComboId());
            ps.setInt(2, foodTicketItem.getQuantity());
            ps.setDouble(3, foodTicketItem.getTotalPrice());
            ps.setInt(4, foodTicketItem.getUserId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MovieTickets getMovieTicketByUserId(int id) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM movie_tickets WHERE userId = ?";
            ps = DbConnect.get(query);  // Lấy PreparedStatement từ DbConnect
            ps.setInt(1, id);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                MovieTickets movieTickets = new MovieTickets();
                movieTickets.setId(resultSet.getInt("id"));
                movieTickets.setShowTimeId(resultSet.getInt("showtimeId"));
                movieTickets.setSeatId(resultSet.getInt("seatId"));
                movieTickets.setPrice(resultSet.getDouble("price"));
                movieTickets.setCreatedAt(resultSet.getString("created_at"));
                movieTickets.setUserId(resultSet.getInt("userId"));
                return movieTickets;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public FoodTicketItem getFoodTicketItemByUserId(int id) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM food_ticket_items WHERE userId = ?";
            ps = DbConnect.get(query);  // Lấy PreparedStatement từ DbConnect
            ps.setInt(1, id);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                FoodTicketItem foodTicketItem = new FoodTicketItem();
                foodTicketItem.setId(resultSet.getInt("id"));
                foodTicketItem.setComboId(resultSet.getInt("comboId"));
                foodTicketItem.setQuantity(resultSet.getInt("quantity"));
                foodTicketItem.setTotalPrice(resultSet.getDouble("price"));
                foodTicketItem.setUserId(resultSet.getInt("userId"));
                return foodTicketItem;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<MovieTickets> getTikeckMovieByID(String id) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<MovieTickets> movieTickets = new ArrayList<MovieTickets>();
        try {
            String query = "SELECT m.title, s.roomId, se.row, se.seat_number, s.showDate, s.showTime, m_t.price " +
                    "FROM movie_tickets m_t " +
                    "JOIN seats se ON se.id = m_t.seatId " +
                    "JOIN showtimes s ON s.id = m_t.showTimeId " +
                    "JOIN movies m ON m.id = s.movieId " +
                    "WHERE m_t.userId = ? ";

            ps = DbConnect.get(query);
            ps.setString(1,id);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                MovieTickets movieTicket = new MovieTickets(
                        resultSet.getDouble("price"),
                        resultSet.getString("title"),
                        resultSet.getString("roomId"),
                        resultSet.getString("row"),
                        resultSet.getString("seat_number"),
                        resultSet.getDate("showDate").toLocalDate(),
                        resultSet.getTime("showTime").toLocalTime()
                );
                movieTickets.add(movieTicket);
            }
            return movieTickets;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TicketDao ticketDao = new TicketDao();
        List<MovieTickets> movieTickets = ticketDao.getTikeckMovieByID("22");
        for (MovieTickets movieTicket : movieTickets) {
            System.out.println(movieTicket.getPrice());
        }
    }
}
