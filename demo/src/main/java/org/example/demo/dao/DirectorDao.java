package org.example.demo.dao;

import org.example.demo.dao.db.DbConnect;
import org.example.demo.dao.model.Director;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DirectorDao {
    public List<Director> getMovieDirectors(int movieId) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Director> directors = new ArrayList<>();

        try {
            String query = """
                SELECT d.id, d.name 
                FROM movie_directors md
                INNER JOIN directors d ON md.directorId = d.id
                WHERE md.movieId = ?;
            """;

            ps = DbConnect.get(query);  // Lấy PreparedStatement từ DbConnect
            ps.setInt(1, movieId);  // Đặt giá trị ID phim vào câu lệnh

            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                // Tạo đối tượng Director từ kết quả trả về
                Director director = new Director();
                director.setId(resultSet.getInt("id"));
                director.setName(resultSet.getString("name"));
                directors.add(director);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi (nên dùng logging framework)
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();  // Log lỗi khi đóng tài nguyên
            }
        }

        return directors;
    }

    public static void main(String[] args) {
        DirectorDao directorDao = new DirectorDao();
        List<Director> directors = directorDao.getMovieDirectors(1);
        for (Director director : directors) {
            System.out.println(director.getId() + " - " + director.getName());
        }
    }
}
