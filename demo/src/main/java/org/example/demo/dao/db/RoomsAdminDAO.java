package org.example.demo.dao.db;

import org.example.demo.dao.model.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomsAdminDAO {
    private Connection connection;

    public RoomsAdminDAO(Connection connection) {
        this.connection = connection;
    }

    // Lấy danh sách phòng chiếu
    public List<Room> getAllRooms() throws SQLException {
        List<Room> roomsList = new ArrayList<>();
        String query = "SELECT * FROM rooms";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Room room = new Room(
                        rs.getInt("id"),
                        rs.getString("roomName")
                );
                roomsList.add(room);
            }
        }
        return roomsList;
    }
}