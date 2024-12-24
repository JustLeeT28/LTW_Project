package org.example.demo.service;

import org.example.demo.dao.db.MoviesDao;
import org.example.demo.model.Movies;

import java.util.List;

public class MoviesService {
    private final org.example.demo.dao.db.MoviesDao moviesDAO = new MoviesDao();

    public List<Movies> getMovies() {
        return moviesDAO.getAllMovies();
    }

    public boolean addMovie(Movies movie) {
        return moviesDAO.addMovie(movie);
    }

    public boolean deleteMovie(int id) {
        return moviesDAO.deleteMovie(id);
    }
}
