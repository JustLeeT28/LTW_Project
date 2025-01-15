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
            String query = "SELECT mt.id, mt.orderId, mt.showTimeId, mt.seatId, mt.price, mt.created_at, u.name ,sh.showDate,sh.showTime,sh.roomId " +
                    "FROM movie_tickets mt " +
                    "JOIN orders o ON mt.orderId = o.id " +
                    "JOIN users u ON o.userId = u.id " +
                    "JOIN showtimes sh On mt.showTimeId = sh.id " +
                    "ORDER BY mt.created_at DESC";
            ps = DbConnect.get(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                MovieTicket ticket = new MovieTicket(
                        rs.getInt("id"),               // id
                        rs.getInt("orderId"),          // orderId
                        rs.getInt("showTimeId"),       // showTimeId
                        rs.getInt("seatId"),           // seatId
                        rs.getDouble("price"),         // price
                        rs.getString("created_at"),     // createdAt
                        rs.getString("name"),          // nameUser
                        rs.getString("showDate"),      // dayshow
                        rs.getString("showTime"),      // timeshow
                        rs.getInt("roomId")            // roomId
                );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MovieTicket> getTicketMovieByName(String queryTikket) {
        List<MovieTicket> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT mt.id, mt.orderId, mt.showTimeId, mt.seatId, mt.price, mt.created_at, u.name ,sh.showDate,sh.showTime,sh.roomId " +
                    "FROM movie_tickets mt " +
                    "JOIN orders o ON mt.orderId = o.id " +
                    "JOIN users u ON o.userId = u.id " +
                    "JOIN showtimes sh On mt.showTimeId = sh.id " +
                    "Where u.name LIKE ? " +
                    "ORDER BY mt.created_at DESC";
            ps = DbConnect.get(query);
            ps.setString(1, "%" + queryTikket + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                MovieTicket ticket = new MovieTicket(
                        rs.getInt("id"),               // id
                        rs.getInt("orderId"),          // orderId
                        rs.getInt("showTimeId"),       // showTimeId
                        rs.getInt("seatId"),           // seatId
                        rs.getDouble("price"),         // price
                        rs.getString("created_at"),     // createdAt
                        rs.getString("name"),          // nameUser
                        rs.getString("showDate"),      // dayshow
                        rs.getString("showTime"),      // timeshow
                        rs.getInt("roomId")            // roomId
                );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MovieTicket> getTicketMoiveById(String queryTikket) {
        List<MovieTicket> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT mt.id, mt.orderId, mt.showTimeId, mt.seatId, mt.price, mt.created_at, u.name ,sh.showDate,sh.showTime,sh.roomId " +
                    "FROM movie_tickets mt " +
                    "JOIN orders o ON mt.orderId = o.id " +
                    "JOIN users u ON o.userId = u.id " +
                    "JOIN showtimes sh On mt.showTimeId = sh.id " +
                    "Where mt.id LIKE ? " +
                    "ORDER BY mt.created_at DESC";
            ps = DbConnect.get(query);
            ps.setString(1,  queryTikket + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                MovieTicket ticket = new MovieTicket(
                        rs.getInt("id"),               // id
                        rs.getInt("orderId"),          // orderId
                        rs.getInt("showTimeId"),       // showTimeId
                        rs.getInt("seatId"),           // seatId
                        rs.getDouble("price"),         // price
                        rs.getString("created_at"),     // createdAt
                        rs.getString("name"),          // nameUser
                        rs.getString("showDate"),      // dayshow
                        rs.getString("showTime"),      // timeshow
                        rs.getInt("roomId")            // roomId
                );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}