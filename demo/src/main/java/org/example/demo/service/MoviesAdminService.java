package org.example.demo.service;


import org.example.demo.dao.db.MoviesAdminDAO;
import org.example.demo.dao.model.Movie;

import java.sql.SQLException;
import java.util.List;

public class MoviesAdminService {
    private MoviesAdminDAO moviesAdminDAO;

    public MoviesAdminService(MoviesAdminDAO moviesAdminDAO) {
        this.moviesAdminDAO = moviesAdminDAO;
    }

    public List<Movie> getAllMovies() throws SQLException {
        return moviesAdminDAO.getAllMovies();
    }

    public Movie getMovieById(int id) throws SQLException {
        return moviesAdminDAO.getMovieById(id);
    }

    public void addMovie(Movie movie) throws SQLException {
        moviesAdminDAO.addMovie(movie);
    }

    public void updateMovie(Movie movie) throws SQLException {
        moviesAdminDAO.updateMovie(movie);
    }

    public void deleteMovie(int id) throws SQLException {
        moviesAdminDAO.deleteMovie(id);
    }
}
