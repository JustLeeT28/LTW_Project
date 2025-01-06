package org.example.demo.dao;

import org.example.demo.dao.db.DbConnect;
import org.example.demo.dao.model.Movie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDao {
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

    public List<Movie> showingMovies() {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            // Query lấy phim đang chiếu (dựa vào releaseDate và endDate)
            String query = "SELECT * FROM movies WHERE releaseDate <= CURRENT_DATE AND endDate >= CURRENT_DATE";
            ps = DbConnect.get(query); // Lấy PreparedStatement từ DbConnect

            resultSet = ps.executeQuery(); // Thực thi truy vấn

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

            return movies; // Trả về danh sách phim đang chiếu

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

    public List<Movie> incomingMovies() {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            // Query lấy phim đang chiếu (dựa vào releaseDate và endDate)
            String query = " SELECT * FROM movies WHERE releaseDate > CURRENT_DATE ";

            ps = DbConnect.get(query); // Lấy PreparedStatement từ DbConnect

            resultSet = ps.executeQuery(); // Thực thi truy vấn

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

            return movies; // Trả về danh sách phim đang chiếu

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


    public Movie getMovieById(int id) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM movies WHERE id = ?";
            ps = DbConnect.get(query);  // Lấy PreparedStatement từ DbConnect

            ps.setInt(1, id);  // Set tham số cho PreparedStatement

            resultSet = ps.executeQuery();  // Thực thi truy vấn

            if (resultSet.next()) {
                return new Movie(
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
            }

            return null;  // Trả về null nếu không tìm thấy phim

        } catch (SQLException e) {
            e.printStackTrace();  // Log lỗi
            return null;  // Trả về null khi gặp lỗi
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

    public static void main(String[] args) {
        MovieDao movieDao = new MovieDao();
        List<Movie> movies = movieDao.getMovies();
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}
