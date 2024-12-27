package org.example.demo.service;

import org.example.demo.dao.MovieDao;
import org.example.demo.dao.models.Movie;

import java.util.List;

public class MovieService {
    MovieDao movieDao = new MovieDao();
    public List<Movie> getMovies() {
        return movieDao.getMovies();
    }
}