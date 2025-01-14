package org.example.demo.dao;
import org.example.demo.dao.db.DbConnect;
import org.example.demo.dao.model.Genre;
import org.example.demo.dao.model.Movie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AddMovieDao {
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


    public int addMovie(String title, String posterUrl, String bannerUrl, String description, String country, String language, String subtitle, String ageRating, String releaseDate, String endDate, String duration) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        int movieId = -1;


        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            // Chuyển đổi chuỗi dob thành java.util.Date
            java.util.Date utilReleaseDate = sdf.parse(releaseDate);
            java.util.Date utilendDate = sdf.parse(endDate);

            // Chuyển đổi java.util.Date thành java.sql.Date
            java.sql.Date sqlreleaseDate = new java.sql.Date(utilReleaseDate.getTime());
            java.sql.Date sqlendDate = new java.sql.Date(utilendDate.getTime());
            String query = "INSERT INTO movies (title, duration, description, country, language, subtitle, ageRating, releaseDate, endDate, bannerUrl, posterUrl) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = DbConnect.get(query);
            ps.setString(1, title);
            ps.setString(2, duration);
            ps.setString(3, description);
            ps.setString(4, country);
            ps.setString(5, language);
            ps.setString(6, subtitle);
            ps.setString(7, ageRating);
            ps.setDate(8, sqlreleaseDate);
            ps.setDate(9, sqlendDate);
            ps.setString(10, bannerUrl);
            ps.setString(11, posterUrl);
            ps.executeUpdate();

            // Lấy ID tự động được tạo
            resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                movieId = resultSet.getInt(1); // Lấy ID từ cột đầu tiên
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return movieId; // Trả về ID của bộ phim (hoặc -1 nếu không thêm được)
    }

    public static List<String> getGenres(String genres) {
        List<String> genresList = new ArrayList<>();
        if (genres != null && !genres.trim().isEmpty()) {
            String[] genresArray = genres.split(","); // Tách chuỗi theo dấu phẩy
            for (String genre : genresArray) {
                genresList.add(genre.trim()); // Loại bỏ khoảng trắng thừa
            }
            return genresList;
        }
        return null;
    }
    public static int idGenre(String genre) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        int genreId = -1;
        try {
            String query = "SELECT id FROM genres WHERE genre = ?";
            ps = DbConnect.get(query);
            ps.setString(1,genre);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                genreId = resultSet.getInt("id");
                return genreId;
            }
            return genreId;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void addGenre_movie(String genres,int movie_newid) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<String> genreList = getGenres(genres);

        try {
            String query = "INSERT INTO movie_genres (movieId,genreId) VALUES (?,?)";
            ps = DbConnect.get(query);
            for (String g : genreList){
                ps.setInt(1,movie_newid);
                int genreId = idGenre(g);
                if(genreId == -1){
                    continue;
                }
                ps.setInt(2,genreId);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

//    public static void main(String[] args) {
//        List<String> test = getGenres("Hành động,    Kinh dị, ngôn tình");
//        for (String genre : test) {
//            System.out.println(genre);
//        }
//    }
}


