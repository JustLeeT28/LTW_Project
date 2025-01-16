package org.example.demo.dao;

import org.example.demo.dao.db.DbConnect;
import org.example.demo.dao.model.FoodTicketItem;
import org.example.demo.dao.model.MovieTickets;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
