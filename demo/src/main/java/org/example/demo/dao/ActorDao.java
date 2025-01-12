package org.example.demo.dao;

import org.example.demo.dao.db.DbConnect;
import org.example.demo.dao.model.Actor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActorDao {
    // Lấy danh sách diễn viên của một bộ phim dựa vào id của phim
    public List<Actor> getMovieActors(int movieId) {
        String query = "SELECT a.id, a.name FROM actors a JOIN movie_actors ma ON a.id = ma.actorId WHERE ma.movieId = ?";
        List<Actor> actors = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            // Sử dụng DbConnect để lấy PreparedStatement
            ps = DbConnect.get(query);

            if (ps != null) {
                // Thiết lập giá trị cho tham số trong câu truy vấn
                ps.setInt(1, movieId);

                // Thực thi truy vấn và lấy kết quả
                resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    // Tạo đối tượng Actor và thêm vào danh sách
                    Actor actor = new Actor();
                    actor.setId(resultSet.getInt("id"));
                    actor.setName(resultSet.getString("name"));
                    actors.add(actor);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đảm bảo đóng tài nguyên
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return actors;
    }

    public static void main(String[] args) {
        ActorDao actorDao = new ActorDao();
        List<Actor> actors = actorDao.getMovieActors(1);
        for (Actor actor : actors) {
            System.out.println(actor.getId() + " - " + actor.getName());
        }
    }
}
