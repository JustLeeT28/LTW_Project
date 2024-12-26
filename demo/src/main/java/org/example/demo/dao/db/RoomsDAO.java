package org.example.demo.dao.db;

import org.example.demo.model.Rooms;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomsDAO {
    private Connection connection;

    public RoomsDAO(Connection connection) {
        this.connection = connection;
    }

    // Lấy danh sách phòng chiếu
    public List<Rooms> getAllRooms() throws SQLException {
        List<Rooms> roomsList = new ArrayList<>();
        String query = "SELECT * FROM rooms";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Rooms room = new Rooms(
                        rs.getInt("id"),
                        rs.getString("roomName")
                );
                roomsList.add(room);
            }
        }
        return roomsList;
    }
}
