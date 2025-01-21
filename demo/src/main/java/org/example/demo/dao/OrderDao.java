package org.example.demo.dao;

import org.example.demo.dao.db.DbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDao {

    public double getTotalFood7() {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        double total = 1.0;
        try{
            String sql = "SELECT SUM(price * quantity) AS total_revenue " +
                    "FROM food_ticket_items " +
                    "WHERE created_at >= CURDATE() - INTERVAL 7 DAY;";

            // Tạo đối tượng PreparedStatement từ kết nối
            ps = DbConnect.get(sql);
            // Thực thi truy vấn và nhận kết quả
            resultSet = ps.executeQuery();

            // Kiểm tra nếu có kết quả trả về
            if (resultSet.next()) {
                // Lấy tổng doanh thu từ kết quả
                total = resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối, PreparedStatement, và ResultSet
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return total;
    }

    public double getTotalMovie7() {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        double total = 1.0;
        try {
            String sql = "SELECT SUM(price) AS total_revenue " +
                    "FROM movie_tickets " +
                    "WHERE created_at >= CURDATE() - INTERVAL 7 DAY";
            // Tạo đối tượng PreparedStatement từ kết nối
            ps = DbConnect.get(sql);
            // Thực thi truy vấn và nhận kết quả
            resultSet = ps.executeQuery();

            // Kiểm tra nếu có kết quả trả về
            if (resultSet.next()) {
                // Lấy tổng doanh thu từ kết quả
                total = resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối, PreparedStatement, và ResultSet
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return total;
    }
}
