package org.example.demo.service;

import org.example.demo.dao.MovieDao;
import org.example.demo.dao.model.Movie;

import java.util.List;

public class MovieService {
    MovieDao movieDao = new MovieDao();

    public List<Movie> getMovies() {
        return movieDao.getMovies();
    }

    public List<Movie> showingMovies() {
        return movieDao.showingMovies();
    }

}
