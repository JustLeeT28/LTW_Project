package org.example.demo.service;

import org.example.demo.dao.MovieDao;
import org.example.demo.dao.model.Genre;
import org.example.demo.dao.model.Movie;

import java.util.List;

public class MovieService {
    MovieDao movieDao = new MovieDao();
    public List<Movie> getMovies() {
        return movieDao.getMovies();
    }
    public List<Movie> getGenreMovies(String genre) {
        return movieDao.getGenreMovies(genre);
    }
    public List<Genre> getGenres() {
        return movieDao.getGenres();
    }

    public List<Movie> getConditionMovies(String condition) {
        return  movieDao.getConditionMovie(condition);
    }
    public List<Movie> getGenAndConMovie(String condition, String genre) {
        return movieDao.getGenAndConMovie(condition, genre);
    }
}
