package org.example.demo.service;

import org.example.demo.dao.MoviesAdminDAO;
import org.example.demo.dao.models.Movie;

import java.util.List;

public class MoviesAdminService {
    private final MoviesAdminDAO moviesAdminDAO;

    public MoviesAdminService() {
        this.moviesAdminDAO = new MoviesAdminDAO();
    }

    public List<Movie> getAllMovies() {
        return moviesAdminDAO.getAllMovies();
    }

    public boolean addMovie(Movie movie) {
        return moviesAdminDAO.addMovie(movie);
    }

    public boolean deleteMovie(int id) {
        return moviesAdminDAO.deleteMovie(id);
    }
}
