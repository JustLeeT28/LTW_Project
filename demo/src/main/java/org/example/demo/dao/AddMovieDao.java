package org.example.demo.dao;
import org.example.demo.dao.db.DbConnect;
import org.example.demo.dao.model.Genre;
import org.example.demo.dao.model.Movie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AddMovieDao {

    public static int geIdBynameMovie(String name) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT id FROM movies WHERE title LIKE ?";
            ps = DbConnect.get(query);
            ps.setString(1,name);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
            return -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
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

            // Thực thi lệnh SQL và lấy ID tự động sinh
            ps.executeUpdate();
            movieId = geIdBynameMovie(title);
            return movieId;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

        // tách chuỗi tên thành các tên
    public static List<String> getStringofList(String text) {
        List<String> listText = new ArrayList<>();
        if (text != null && !text.trim().isEmpty()) {
            String[] textArray = text.split(","); // Tách chuỗi theo dấu phẩy
            for (String t : textArray) {
                listText.add(t.trim()); // Loại bỏ khoảng trắng thừa
            }
            return listText;
        }
        return null;
    }

    // lay id thể loại từ tên thể loại
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
    // thêm thể loại cho movie ở bảng trung gian
    public void addGenre_movie(String genres,int movie_newid) {
        PreparedStatement ps = null;
//        ResultSet resultSet = null;
        List<String> genreList = getStringofList(genres);

        try {
            String checkQuery = "SELECT COUNT(*) FROM movie_genres WHERE movieId = ? AND genreId = ?";
            String query = "INSERT INTO movie_genres (movieId,genreId) VALUES (?,?)";
            ps = DbConnect.get(query);
            PreparedStatement psCheck = DbConnect.get(checkQuery);
            for (String g : genreList){
                ps.setInt(1,movie_newid);
                int genreId = idGenre(g);
                if (genreId == -1) continue;
                // Kiểm tra nếu đã tồn tại
                psCheck.setInt(1, movie_newid);
                psCheck.setInt(2, genreId);
                ResultSet rs = psCheck.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    // Đã tồn tại, bỏ qua
                    continue;
                }
                ps.setInt(2,genreId);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    // lay id đạo diễn từ tên
    public static int idDirector(String directors) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        int dirId = -1;
        try {
            String query = "SELECT id FROM directors WHERE name = ?";
            ps = DbConnect.get(query);
            ps.setString(1,directors);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                dirId = resultSet.getInt("id");
                return dirId;
            }
            return dirId;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void addDirector(String director) {
        PreparedStatement ps = null;
//        ResultSet resultSet = null;
        try {
            String query = "INSERT INTO directors (name) VALUES (?)";
            ps = DbConnect.get(query);
            ps.setString(1,director);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public void addDirector_movie(String directors, int movieNewid) {
        PreparedStatement ps = null;
        List<String> dirList = getStringofList(directors);
        try {
            String query = "INSERT INTO movie_directors (movieId,directorId) VALUES (?,?)";
            ps = DbConnect.get(query);
            for (String g : dirList){
                ps.setInt(1,movieNewid);
                int dirId = idDirector(g);
                if(dirId == -1){
                    addDirector(g);
                    dirId = idDirector(g); // lấy id sau khi tạo
                }
                if(dirId == -1){ // nếu vẫn k tạo đc
                    continue;
                }
                ps.setInt(2,dirId);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int idActor(String actor) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        int actorId = -1;
        try {
            String query = "SELECT id FROM actors WHERE name = ?";
            ps = DbConnect.get(query);
            ps.setString(1,actor);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                actorId = resultSet.getInt("id");
                return actorId;
            }
            return actorId;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void addActor(String actor) {
        PreparedStatement ps = null;
//        ResultSet resultSet = null;
        try {
            String query = "INSERT INTO actors (name) VALUES (?)";
            ps = DbConnect.get(query);
            ps.setString(1,actor);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public void addActor_movie(String actors, int movieNewid) {
        PreparedStatement ps = null;
        List<String> actorList = getStringofList(actors);
        try {
            String query = "INSERT INTO movie_actors (movieId,actorId) VALUES (?,?)";
            ps = DbConnect.get(query);
            for (String g : actorList){
                ps.setInt(1,movieNewid);
                int actorId = idActor(g);
                if(actorId == -1){
                    addActor(g);
                    actorId = idActor(g); // lấy id sau khi tạo
                }
                if(actorId == -1){ // nếu vẫn k tạo đc
                    continue;
                }
                ps.setInt(2,actorId);
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


