package org.example.demo.dao;

import org.example.demo.dao.db.DbConnect;
import org.example.demo.dao.model.FoodCombo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDao {
    public List<FoodCombo> getFoodCombo() {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<FoodCombo> foodCombos = new ArrayList<>();
        try {
            String query = "SELECT * FROM food_combos";
            ps = DbConnect.get(query);  // Lấy PreparedStatement từ DbConnect
            resultSet = ps.executeQuery();  // Thực thi truy vấn
            while (resultSet.next()) {
                // Lấy dữ liệu từ ResultSet và thêm vào list
                FoodCombo foodCombo = new FoodCombo(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getString("description"),
                        resultSet.getString("status")
                );
                foodCombos.add(foodCombo);
            }
            return foodCombos;
        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi (có thể thay thế bằng việc báo cáo lỗi rõ ràng hơn)
            return new ArrayList<>();  // Trả về danh sách rỗng khi gặp lỗi
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();  // Log lỗi khi đóng tài nguyên
            }
        }
    }
    public List<FoodCombo> getFoodComboById(int id) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<FoodCombo> foodCombos = new ArrayList<>();
        try {
            String query = "SELECT * FROM food_combos WHERE id = ?";
            ps = DbConnect.get(query);  // Lấy PreparedStatement từ DbConnect
            ps.setInt(1, id);  // Set tham số cho PreparedStatement
            resultSet = ps.executeQuery();  // Thực thi truy vấn
            while (resultSet.next()) {
                // Lấy dữ liệu từ ResultSet và thêm vào list
                FoodCombo foodCombo = new FoodCombo(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getString("description"),
                        resultSet.getString("status")
                );
                foodCombos.add(foodCombo);
            }
            return foodCombos;
        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi (có thể thay thế bằng việc báo cáo lỗi rõ ràng hơn)
            return new ArrayList<>();  // Trả về danh sách rỗng khi gặp lỗi
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();  // Log lỗi khi đóng tài nguyên
            }
        }
    }

}
