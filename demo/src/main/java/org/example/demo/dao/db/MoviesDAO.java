package org.example.demo.dao.db;

import org.example.demo.model.Movies;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MoviesDAO {
    private Connection connection;

    public MoviesDAO(Connection connection) {
        this.connection = connection;
    }

    // Lấy tất cả phim
    public List<Movies> getAllMovies() throws SQLException {
        List<Movies> moviesList = new ArrayList<>();
        String query = "SELECT * FROM movies";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Movies movie = new Movies(
                        rs.getString("posterUrl"),
                        rs.getString("bannerUrl"),
                        rs.getString("endDate"),
                        rs.getString("releaseDate"),
                        rs.getString("ageRating"),
                        rs.getString("genre"),
                        rs.getString("description"),
                        rs.getString("actors"),
                        rs.getInt("duration"),
                        rs.getString("director"),
                        rs.getString("title"),
                        rs.getInt("id")
                );
                moviesList.add(movie);
            }
        }
        return moviesList;
    }

    // Lấy thông tin phim theo ID
    public Movies getMovieById(int id) throws SQLException {
        String query = "SELECT * FROM movies WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Movies(
                            rs.getString("posterUrl"),
                            rs.getString("bannerUrl"),
                            rs.getString("endDate"),
                            rs.getString("releaseDate"),
                            rs.getString("ageRating"),
                            rs.getString("genre"),
                            rs.getString("description"),
                            rs.getString("actors"),
                            rs.getInt("duration"),
                            rs.getString("director"),
                            rs.getString("title"),
                            rs.getInt("id")
                    );
                }
            }
        }
        return null;
    }

    // Thêm phim mới
    public void addMovie(Movies movie) throws SQLException {
        String query = "INSERT INTO movies (title, director, duration, actors, description, genre, ageRating, releaseDate, endDate, bannerUrl, posterUrl) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, movie.getTitle());
            stmt.setString(2, movie.getDirector());
            stmt.setInt(3, movie.getDuration());
            stmt.setString(4, movie.getActors());
            stmt.setString(5, movie.getDescription());
            stmt.setString(6, movie.getGenre());
            stmt.setString(7, movie.getAgeRating());
            stmt.setString(8, movie.getReleaseDate());
            stmt.setString(9, movie.getEndDate());
            stmt.setString(10, movie.getBannerUrl());
            stmt.setString(11, movie.getPosterUrl());
            stmt.executeUpdate();
        }
    }

    // Cập nhật thông tin phim
    public void updateMovie(Movies movie) throws SQLException {
        String query = "UPDATE movies SET title = ?, director = ?, duration = ?, actors = ?, description = ?, genre = ?, ageRating = ?, releaseDate = ?, endDate = ?, bannerUrl = ?, posterUrl = ? " +
                "WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, movie.getTitle());
            stmt.setString(2, movie.getDirector());
            stmt.setInt(3, movie.getDuration());
            stmt.setString(4, movie.getActors());
            stmt.setString(5, movie.getDescription());
            stmt.setString(6, movie.getGenre());
            stmt.setString(7, movie.getAgeRating());
            stmt.setString(8, movie.getReleaseDate());
            stmt.setString(9, movie.getEndDate());
            stmt.setString(10, movie.getBannerUrl());
            stmt.setString(11, movie.getPosterUrl());
            stmt.setInt(12, movie.getId());
            stmt.executeUpdate();
        }
    }

    // Xóa phim
    public void deleteMovie(int id) throws SQLException {
        String query = "DELETE FROM movies WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
