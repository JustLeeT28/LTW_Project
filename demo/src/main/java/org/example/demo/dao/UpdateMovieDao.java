package org.example.demo.dao;
import org.example.demo.dao.db.DbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UpdateMovieDao {

//    public static int geIdBynameMovie(String name) {
//        PreparedStatement ps = null;
//        ResultSet resultSet = null;
//        try {
//            String query = "SELECT id FROM movies WHERE title LIKE ?";
//            ps = DbConnect.get(query);
//            ps.setString(1,name);
//            resultSet = ps.executeQuery();
//            if (resultSet.next()) {
//                return resultSet.getInt("id");
//            }
//            return -1;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public void updateTitle(int movieId, String title) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            String updateQuery = "UPDATE movies SET title = ? WHERE id = ?";
            ps = DbConnect.get(updateQuery);
            ps.setString(1, title);
            ps.setInt(2, movieId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePosterUrl(int movieId, String posterUrl) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String updateQuery = "UPDATE movies SET posterUrl = ? WHERE id = ?";
            ps = DbConnect.get(updateQuery);
            ps.setString(1, posterUrl);
            ps.setInt(2, movieId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateBannerUrl(int movieId, String bannerUrl) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String updateQuery = "UPDATE movies SET bannerUrl = ? WHERE id = ?";
            ps = DbConnect.get(updateQuery);
            ps.setString(1, bannerUrl);
            ps.setInt(2, movieId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateDescription(int movieId, String description) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String updateQuery = "UPDATE movies SET description = ? WHERE id = ?";
            ps = DbConnect.get(updateQuery);
            ps.setString(1, description);
            ps.setInt(2, movieId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCountry(int movieId, String country) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String updateQuery = "UPDATE movies SET country = ? WHERE id = ?";
            ps = DbConnect.get(updateQuery);
            ps.setString(1, country);
            ps.setInt(2, movieId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateLanguage(int movieId, String language) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String updateQuery = "UPDATE movies SET language = ? WHERE id = ?";
            ps = DbConnect.get(updateQuery);
            ps.setString(1, language);
            ps.setInt(2, movieId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateSubtitle(int movieId, String subtitle) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String updateQuery = "UPDATE movies SET subtitle = ? WHERE id = ?";
            ps = DbConnect.get(updateQuery);
            ps.setString(1, subtitle);
            ps.setInt(2, movieId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateDuration(int movieId, String duration) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String updateQuery = "UPDATE movies SET duration = ? WHERE id = ?";
            ps = DbConnect.get(updateQuery);
            ps.setString(1, duration);
            ps.setInt(2, movieId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAgeRating(int movieId, String ageRating) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String updateQuery = "UPDATE movies SET ageRating = ? WHERE id = ?";
            ps = DbConnect.get(updateQuery);
            ps.setString(1, ageRating);
            ps.setInt(2, movieId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateReleaseDate(int movieId, String releaseDate) {
        PreparedStatement ps = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = sdf.parse(releaseDate);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            String updateQuery = "UPDATE movies SET releaseDate = ? WHERE id = ?";
            ps = DbConnect.get(updateQuery);
            ps.setDate(1, sqlDate);
            ps.setInt(2, movieId);
            ps.executeUpdate();

        } catch (ParseException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateEndDate(int movieId, String endDate) {
        PreparedStatement ps = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = sdf.parse(endDate);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            String updateQuery = "UPDATE movies SET endDate = ? WHERE id = ?";
            ps = DbConnect.get(updateQuery);
            ps.setDate(1, sqlDate);
            ps.setInt(2, movieId);
            ps.executeUpdate();

        } catch (ParseException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void updateGenres(int movieId, String genres) {
        AddMovieDao addMovieDao = new AddMovieDao();
        String deleteMovieGenreQuery = "DELETE FROM movie_genres WHERE movieId = ?";
        PreparedStatement deleteMovieGenrePs = null;
        try {
            deleteMovieGenrePs = DbConnect.get(deleteMovieGenreQuery);
            deleteMovieGenrePs.setInt(1, movieId);
            deleteMovieGenrePs.executeUpdate();
            addMovieDao.addGenre_movie(genres, movieId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void updateDirectors(int movieId, String directors) {
        AddMovieDao addMovieDao = new AddMovieDao();
        String deleteQuery = "DELETE FROM movie_directors WHERE movieId = ?";
        PreparedStatement ps = null;
        try {
            ps = DbConnect.get(deleteQuery);
            ps.setInt(1, movieId);
            ps.executeUpdate();
            addMovieDao.addDirector_movie(directors, movieId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateActors(int movieId, String actors) {
        AddMovieDao addMovieDao = new AddMovieDao();
        String deleteQuery = "DELETE FROM movie_actors WHERE movieId = ?";
        PreparedStatement ps = null;
        try {
            ps = DbConnect.get(deleteQuery);
            ps.setInt(1, movieId);
            ps.executeUpdate();
            addMovieDao.addActor_movie(actors, movieId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
