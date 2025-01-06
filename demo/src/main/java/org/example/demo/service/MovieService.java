package org.example.demo.service;

import org.example.demo.dao.ActorDao;
import org.example.demo.dao.DirectorDao;
import org.example.demo.dao.MovieDao;
import org.example.demo.dao.model.Actor;
import org.example.demo.dao.model.Director;
import org.example.demo.dao.model.Movie;

import java.util.List;

public class MovieService {
    MovieDao movieDao = new MovieDao();
    DirectorDao directorDao = new DirectorDao();
    ActorDao actorDao = new ActorDao();

    public List<Movie> getMovies() {
        return movieDao.getMovies();
    }

    public List<Movie> showingMovies() {
        return movieDao.showingMovies();
    }

    public Movie getMovieById(int id) {
        return movieDao.getMovieById(id);
    }
    public List<Director> getDirectors(int id) {
        return directorDao.getMovieDirectors(id);
    }
    public List<Actor> getActors(int id) {
        return actorDao.getMovieActors(id);
    }
}
