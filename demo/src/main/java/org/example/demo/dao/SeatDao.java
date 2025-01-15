package org.example.demo.dao;

import com.mysql.cj.jdbc.JdbcConnection;
import org.example.demo.dao.db.DbConnect;
import org.example.demo.dao.model.Movie;
import org.example.demo.dao.model.Seat;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeatDao {
    public List<Seat> getSeatsInRoom(int roomId) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM seats WHERE roomId = ?";

            ps = DbConnect.get(query); // Lấy PreparedStatement từ DbConnect
            ps.setInt(1, roomId); // Set tham số cho PreparedStatement
            resultSet = ps.executeQuery(); // Thực thi truy vấn

            List<Seat> seats = new ArrayList<>();
            while (resultSet.next()) {
                Seat movie = new Seat(
                        resultSet.getInt("id"),
                        resultSet.getInt("roomId"),
                        resultSet.getString("row"),
                        resultSet.getString("seatNumber"),
                        resultSet.getDouble("price"),
                        resultSet.getString("status")
                );
                seats.add(movie);
            }

            return seats;

        } catch (SQLException e) {
            e.printStackTrace(); // Log lỗi
            return new ArrayList<>(); // Trả về danh sách rỗng khi gặp lỗi
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Log lỗi khi đóng tài nguyên
            }
        }
    }
}
