package org.example.demo.dao;

import org.example.demo.dao.db.DbConnect;
import org.example.demo.dao.model.Room;
import org.example.demo.dao.model.Seat;
import org.example.demo.dao.model.Showtime;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class ShowtimeDao {
    public List<Showtime> getShowTime(int movieId) {
        {
            PreparedStatement ps = null;
            ResultSet resultSet = null;
            try {
                String query = "SELECT * FROM showtimes WHERE movieId = ?";

                ps = DbConnect.get(query); // Lấy PreparedStatement từ DbConnect
                ps.setInt(1, movieId); // Set tham số cho PreparedStatement
                resultSet = ps.executeQuery(); // Thực thi truy vấn
                List<Showtime> showtimes = new ArrayList<>();
                while (resultSet.next()) {
                    Showtime showtime = new Showtime(
                            resultSet.getInt("id"),
                            resultSet.getInt("movieId"),
                            resultSet.getInt("roomId"),
                            resultSet.getDate("showDate").toLocalDate(),
                            resultSet.getTime("showTime").toLocalTime(),
                            resultSet.getString("status")
                    );
                    showtimes.add(showtime);
                }
                return showtimes;
            } catch (SQLException e) {
                e.printStackTrace(); // Log lỗi
                return new ArrayList<>();
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

    public static void main(String[] args) {

    }
}
