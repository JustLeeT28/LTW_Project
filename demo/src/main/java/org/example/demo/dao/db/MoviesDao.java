package org.example.demo.dao.db;

import org.example.demo.model.Movies;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MoviesDao {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public List<Movies> getAllMovies() {
        List<Movies> movies = new ArrayList<>();
        String sql = "SELECT * FROM movies WHERE status = 'active'";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Movies movie = new Movies(
                        rs.getString("poster_url"),
                        rs.getString("banner_url"),
                        rs.getString("end_date"),
                        rs.getString("release_date"),
                        rs.getString("age_rating"),
                        rs.getString("genre"),
                        rs.getString("description"),
                        null, // Actors and directors will be handled later
                        rs.getInt("duration"),
                        null, // Set director later
                        rs.getString("title"),
                        rs.getInt("id")
                );
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public boolean addMovie(Movies movie) {
        String sql = "INSERT INTO movies (title, duration, description, genre, age_rating, release_date, end_date, banner_url, poster_url, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, 'active')";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, movie.getTitle());
            ps.setInt(2, movie.getDuration());
            ps.setString(3, movie.getDescription());
            ps.setString(4, movie.getGenre());
            ps.setString(5, movie.getAgeRating());
            ps.setString(6, movie.getReleaseDate());
            ps.setString(7, movie.getEndDate());
            ps.setString(8, movie.getBannerUrl());
            ps.setString(9, movie.getPosterUrl());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteMovie(int id) {
        String sql = "UPDATE movies SET status = 'inactive' WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

