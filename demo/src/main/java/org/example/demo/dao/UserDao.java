package org.example.demo.dao;
import org.example.demo.controller.LoginController;
import org.example.demo.dao.db.DbConnect;
import org.example.demo.dao.model.Genre;
import org.example.demo.dao.model.Movie;
import org.example.demo.dao.model.User;
import org.example.demo.service.MovieService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public List<Movie> getMovies() {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM movies";
            ps = DbConnect.get(query);  // Lấy PreparedStatement từ DbConnect

            resultSet = ps.executeQuery();  // Thực thi truy vấn

            List<Movie> movies = new ArrayList<>();
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("duration"),
                        resultSet.getString("description"),
                        resultSet.getString("country"),
                        resultSet.getString("language"),
                        resultSet.getString("subtitle"),
                        resultSet.getString("ageRating"),
                        resultSet.getString("releaseDate"),
                        resultSet.getString("endDate"),
                        resultSet.getString("bannerUrl"),
                        resultSet.getString("posterUrl"),
                        resultSet.getString("status")
                );
                movies.add(movie);
            }

            return movies;

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

    public User getUser(String username, String password) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM USERS WHERE email = ? AND password = ?";
            ps = DbConnect.get(query);
            ps.setString(1, username);
            ps.setString(2, password);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("dob"),
                        resultSet.getString("phone"),
                        resultSet.getInt("role"),
                        resultSet.getString("password"),
                        resultSet.getString("status")
                );
                return user; // lấy cái đầu tiên
            }
            return null ;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        UserDao dao = new UserDao();
        String p = "Dung12345";
        String pmd5 = HashUtil.hashWithMD5(p);
        User user = dao.getUser("phamthidung@gmail.com", pmd5);
        if (user != null) {
            System.out.println("User found: " + user);
            System.out.println("User found: " + user.getEmail());
            System.out.println("User found: " + user.getPassword());
        } else {
            System.out.println("User not found.");
        }

    }
}