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
//                    "JOIN orders o ON mt.orderId = o.id " +
                    "LEFT JOIN users u ON mt.userId = u.id " +  // Sử dụng LEFT JOIN để lấy cả vé không có userId
                    "JOIN showtimes sh ON mt.showTimeId = sh.id " +
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
        ResultSet rs = null;
        try {
            String query = "SELECT mt.id, mt.orderId, mt.showTimeId, mt.seatId, mt.price, mt.created_at, u.name ,sh.showDate,sh.showTime,sh.roomId " +
                    "FROM movie_tickets mt " +
//                    "JOIN orders o ON mt.orderId = o.id " +
                    "LEFT JOIN users u ON mt.userId = u.id " +  // Sử dụng LEFT JOIN để lấy cả vé không có userId
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
        ResultSet rs = null;
        try {
            String query = "SELECT mt.id, mt.orderId, mt.showTimeId, mt.seatId, mt.price, mt.created_at, u.name ,sh.showDate,sh.showTime,sh.roomId " +
                    "FROM movie_tickets mt " +
//                    "JOIN orders o ON mt.orderId = o.id " +
                    "LEFT JOIN users u ON mt.userId = u.id " +  // Sử dụng LEFT JOIN để lấy cả vé không có userId
                    "JOIN showtimes sh ON mt.showTimeId = sh.id " +
                    "Where mt.id = ? " +
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
                list.add(ticket);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update2D(int p) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "UPDATE seats s " +
                    "JOIN rooms r ON s.roomId = r.id " +
                    "SET s.price = ? " +
                    "WHERE r.style = ?";
            ps = DbConnect.get(query);
            ps.setInt(1,p);
            ps.setString(2,"2D");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update3D(int p) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "UPDATE seats s " +
                    "JOIN rooms r ON s.roomId = r.id " +
                    "SET s.price = ? " +
                    "WHERE r.style = ?";
            ps = DbConnect.get(query);
            ps.setInt(1,p);
            ps.setString(2,"3D");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update4D(int p) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "UPDATE seats s " +
                    "JOIN rooms r ON s.roomId = r.id " +
                    "SET s.price = ? " +
                    "WHERE r.style = ?";
            ps = DbConnect.get(query);
            ps.setInt(1,p);
            ps.setString(2,"4Dx");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateImax(int p) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "UPDATE seats s " +
                    "JOIN rooms r ON s.roomId = r.id " +
                    "SET s.price = ? " +
                    "WHERE r.style = ?";
            ps = DbConnect.get(query);
            ps.setInt(1,p);
            ps.setString(2,"Imax");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TicketMovieDao dao = new TicketMovieDao();
        List<MovieTicket> list = dao.getTicketAll();
        for (MovieTicket ticket : list) {
            System.out.println(ticket.getId());
        }

    }

    public void delTicketById(String ticketIdDel) {
        PreparedStatement ps = null;
        int id = Integer.parseInt(ticketIdDel);
        try {
            String query = "DELETE FROM movie_tickets WHERE id = ?";
            ps = DbConnect.get(query);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
    }

}