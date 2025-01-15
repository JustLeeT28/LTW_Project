package org.example.demo.dao;

import org.example.demo.dao.db.DbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDao {

    public double getTotalR7() {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        double total = 1.0;
        try{
            String sql = "SELECT SUM(totalPrice) FROM orders " +
                    "WHERE order_date >= CURRENT_DATE - INTERVAL 7 DAY";

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
