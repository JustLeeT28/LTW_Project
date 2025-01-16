package org.example.demo.dao;

import org.example.demo.dao.db.DbConnect;
import org.example.demo.dao.model.Room;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDao {
    public void updateRoomStyle(int i, String styleRoom) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "update rooms set style = ? where id = ?";
            ps = DbConnect.get(sql);
            ps.setString(1,styleRoom);
            ps.setInt(2,i);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateRoomOccupancy(int i, int o) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "update rooms set occupancy = ? where id = ?";
            ps = DbConnect.get(sql);
            ps.setInt(1,o);
            ps.setInt(2,i);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Room> getAllRoom() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Room> rooms = new ArrayList<Room>();
        try {
            String sql = "select * from rooms";
            ps = DbConnect.get(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Room r = new Room(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("style"),
                        rs.getInt("occupancy"),
                        rs.getString("status")
                        );
                rooms.add(r);
            }
            return rooms;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void blockRoom(int roomId) {
        PreparedStatement ps = null;
        try {
            String sql = "update rooms set status = ? where id = ?";
            ps = DbConnect.get(sql);
            ps.setString(1,"inactive");
            ps.setInt(2,roomId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void unblockRoom(int roomId) {
        PreparedStatement ps = null;
        try {
            String sql = "update rooms set status = ? where id = ?";
            ps = DbConnect.get(sql);
            ps.setString(1,"active");
            ps.setInt(2,roomId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getPrice(String styleRoom) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int price = 0;
        try {
            String sql = "select s.price from seats s " +
                    "JOIN rooms r ON r.id = s.roomId " +
                    "where r.style = ?";
            ps = DbConnect.get(sql);
            ps.setString(1,styleRoom);
            rs = ps.executeQuery();
            if (rs.next()) {
                price = rs.getInt("price");
            }
            return price;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
