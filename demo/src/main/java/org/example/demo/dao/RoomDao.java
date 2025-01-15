package org.example.demo.dao;

import org.example.demo.dao.db.DbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
