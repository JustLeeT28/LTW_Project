package org.example.demo.service;


import org.example.demo.dao.db.MoviesDAO;
import org.example.demo.model.Movies;

import java.sql.SQLException;
import java.util.List;

public class MoviesService {
    private MoviesDAO moviesDAO;

    public MoviesService(MoviesDAO moviesDAO) {
        this.moviesDAO = moviesDAO;
    }

    public List<Movies> getAllMovies() throws SQLException {
        return moviesDAO.getAllMovies();
    }

    public Movies getMovieById(int id) throws SQLException {
        return moviesDAO.getMovieById(id);
    }

    public void addMovie(Movies movie) throws SQLException {
        moviesDAO.addMovie(movie);
    }

    public void updateMovie(Movies movie) throws SQLException {
        moviesDAO.updateMovie(movie);
    }

    public void deleteMovie(int id) throws SQLException {
        moviesDAO.deleteMovie(id);
    }
}
