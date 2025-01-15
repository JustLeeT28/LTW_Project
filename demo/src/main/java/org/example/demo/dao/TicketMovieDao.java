package org.example.demo.dao;

import org.example.demo.dao.db.DbConnect;
import org.example.demo.dao.model.MovieTicket;
import org.example.demo.dao.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketMovieDao {
    public List<MovieTicket> getTicketAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<MovieTicket> list = new ArrayList<MovieTicket>();
        try {
            String query = "SELECT mt.id, mt.orderId, mt.showTimeId, mt.seatId, mt.price, mt.createdAt, u.name " +
                    "FROM movie_tickets mt " +
                    "JOIN orders o ON mt.orderId = o.id " +
                    "JOIN users u ON o.userId = u.id " +
                    "ORDER BY created_at DESC";
            ps = DbConnect.get(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                MovieTicket ticket = new MovieTicket(
                        rs.getInt("id"),
                        rs.getInt("orderId"),
                        rs.getInt("showTimeId"),
                        rs.getInt("seatId"),
                        rs.getDouble("price"),
                        rs.getString("createdAt"),
                        rs.getString("name")
                );
                list.add(ticket);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MovieTicket> getTicketMovieByName(String queryTikket) {
        List<MovieTicket> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT mt.id, mt.orderId, mt.showTimeId, mt.seatId, mt.price, mt.createdAt, u.name " +
                    "FROM movie_tickets mt " +
                    "JOIN orders o ON mt.orderId = o.id " +
                    "JOIN users u ON o.userId = u.id " +
                    "WHERE u.name LIKE ?" +
                    "ORDER BY created_at DESC";
            ps = DbConnect.get(query);
            ps.setString(1, "%" + queryTikket + "%");
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                MovieTicket ticket = new MovieTicket(
                        resultSet.getInt("id"),
                        resultSet.getInt("orderId"),
                        resultSet.getInt("showTimeId"),
                        resultSet.getInt("seatId"),
                        resultSet.getDouble("price"),
                        resultSet.getString("createdAt"),
                        resultSet.getString("name")
                );
                list.add(ticket);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MovieTicket> getTicketMoiveById(String queryTikket) {
        List<MovieTicket> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT mt.id, mt.orderId, mt.showTimeId, mt.seatId, mt.price, mt.createdAt, u.name " +
                    "FROM movie_tickets mt " +
                    "JOIN orders o ON mt.orderId = o.id " +
                    "JOIN users u ON o.userId = u.id " +
                    "WHERE mt.id LIKE ?" +
                    "ORDER BY created_at DESC";
            ps = DbConnect.get(query);
            ps.setString(1,  queryTikket + "%");
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                MovieTicket ticket = new MovieTicket(
                        resultSet.getInt("id"),
                        resultSet.getInt("orderId"),
                        resultSet.getInt("showTimeId"),
                        resultSet.getInt("seatId"),
                        resultSet.getDouble("price"),
                        resultSet.getString("createdAt"),
                        resultSet.getString("name")
                );
                list.add(ticket);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}