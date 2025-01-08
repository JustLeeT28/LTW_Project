package org.example.demo.dao.db;

import org.example.demo.dao.model.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MoviesAdminDAO {
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        String query = "SELECT * FROM movies";

        try (PreparedStatement ps = DbConnect.get(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Movie movie = new Movie(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("duration"),
                        rs.getString("description"),
                        rs.getString("country"),
                        rs.getString("language"),
                        rs.getString("subtitle"),
                        rs.getString("age_rating"),
                        rs.getString("release_date"),
                        rs.getString("end_date"),
                        rs.getString("banner_url"),
                        rs.getString("poster_url"),
                        rs.getString("status")
                );
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movies;
    }

    public boolean addMovie(Movie movie) {
        String query = "INSERT INTO movies (title, duration, description, country, language, subtitle, age_rating, release_date, end_date, banner_url, poster_url, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = DbConnect.get(query)) {
            ps.setString(1, movie.getTitle());
            ps.setInt(2, movie.getDuration());
            ps.setString(3, movie.getDescription());
            ps.setString(4, movie.getCountry());
            ps.setString(5, movie.getLanguage());
            ps.setString(6, movie.getSubtitle());
            ps.setString(7, movie.getAgeRating());
            ps.setString(8, movie.getReleaseDate());
            ps.setString(9, movie.getEndDate());
            ps.setString(10, movie.getBannerUrl());
            ps.setString(11, movie.getPosterUrl());
            ps.setString(12, movie.getStatus());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteMovie(int id) {
        String query = "DELETE FROM movies WHERE id = ?";

        try (PreparedStatement ps = DbConnect.get(query)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
