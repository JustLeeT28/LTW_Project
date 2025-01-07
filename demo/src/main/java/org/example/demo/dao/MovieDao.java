package org.example.demo.dao;

import org.example.demo.dao.db.DbConnect;
import org.example.demo.dao.model.Genre;
import org.example.demo.dao.model.Movie;
import org.example.demo.service.MovieService;

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

    public List<Movie> getGenreMovies(String idGenre) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM movies m " +
                    "JOIN movie_genres mg ON mg.movieId = m.id  " +
                    "JOIN genres g ON mg.genreId = g.id " +
                    "WHERE g.id = ?";
            ps = DbConnect.get(query);  // Lấy PreparedStatement từ DbConnect
            ps.setInt(1, Integer.parseInt(idGenre));
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

    public List<Genre> getGenres() {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM genres";
            ps = DbConnect.get(query);
            resultSet = ps.executeQuery();  // Thực thi truy vấn
            List<Genre> genres = new ArrayList<>();
            while (resultSet.next()) {
                Genre g = new Genre(
                        resultSet.getInt("id"),
                        resultSet.getString("genre")
                );
                genres.add(g);
            }
            return genres;
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

    public List<Movie> getConditionMovie(String condition){
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String query = "";
        try {
            if(condition.equalsIgnoreCase("hot")){
                query = "SELECT m.*, COUNT(st_s.id) as total_booked_seat " +
                        "FROM movies m " +
                        "LEFT JOIN showtimes st ON m.id = st.movieId " +
                        "LEFT JOIN showtime_seats st_s ON st.id = st_s.showTimeId AND st_s.status = 'booked' " +
                        "GROUP BY m.id " +
                        "ORDER BY total_booked_seat DESC";
            }
            if(condition.equalsIgnoreCase("new")){
                query = "SELECT * " +
                        "FROM movies " +
                        "WHERE releaseDate <= CURRENT_DATE AND endDate >= CURRENT_DATE "+
                        "ORDER BY releaseDate DESC" ;
            }
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

    public List<Movie> getGenreAndConditionMovie(String condition){
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String query = "";
        try {
            if(condition.equalsIgnoreCase("hot")){
                query = "SELECT m.*, COUNT(st_s.id) as total_booked_seat " +
                        "FROM movies m " +
                        "LEFT JOIN showtimes st ON m.id = st.movieId " +
                        "LEFT JOIN showtime_seats st_s ON st.id = st_s.showTimeId AND st_s.status = 'booked' " +
                        "GROUP BY m.id " +
                        "ORDER BY total_booked_seat DESC";
            }
            if(condition.equalsIgnoreCase("new")){
                query = "SELECT * " +
                        "FROM movies " +
                        "WHERE releaseDate <= CURRENT_DATE AND endDate >= CURRENT_DATE "+
                        "ORDER BY releaseDate DESC" ;
            }
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

    public static void main(String[] args) {
                MovieService movieService = new MovieService();

                // Giả sử bạn muốn test với genre có id là 1
                String genreId = "1";
                List<Movie> movies2 = movieService.getMovies();
//              List<Movie> movies = movieService.getGenreMovies(genreId);
                List<Movie> movies = movieService.getConditionMovies("hot");

                // In danh sách các phim lấy được ra console để kiểm tra
                if (movies.isEmpty()) {
                    System.out.println("Không tìm thấy phim nào với thể loại này.");
                } else {
                    for (Movie movie : movies) {
                        System.out.println(movie.getTitle()+"--"+movie.getEndDate()); // Giả sử Movie có phương thức getTitle() để lấy tên phim
                    }
                }

//                 for (Movie movie : movies2) {
//            System.out.println(movie.getTitle()); // Giả sử Movie có phương thức getTitle() để lấy tên phim
//                }
    }


}
