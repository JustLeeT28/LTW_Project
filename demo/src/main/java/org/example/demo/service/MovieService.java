package org.example.demo.service;

import org.example.demo.dao.ActorDao;
import org.example.demo.dao.DirectorDao;
import org.example.demo.dao.MovieDao;
import org.example.demo.dao.model.Actor;
import org.example.demo.dao.model.Director;

import org.example.demo.dao.model.Genre;
import org.example.demo.dao.model.Movie;

import java.util.ArrayList;
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
    public List<Movie> geMoviesByname(String nameMovie) {
        return movieDao.getMoviesByName(nameMovie);
    }

    public List<Movie> getMoviesByNGC(String nameMovie, String genre, String condition) {
        return movieDao.getMoviesByNGC(nameMovie,genre,condition);
    }

    public List<Movie> getMoviesA_Z() {
        return movieDao.getMoviesA_Z();
    }

    public List<Movie> getMovieNow() {
        return movieDao.getMovieNow();
    }

    public List<Movie> getMovieFuture() {return movieDao.getMovieFuture();}

    public List<Movie> getMoviesByQuery(String queryMovie) {
        List<Movie> list = new ArrayList<>();
        if(isActor(queryMovie)){
            String actor = queryMovie.replaceFirst("^AC:","");
            return movieDao.getMovieByActor(actor);
        } else if (isDIR(queryMovie)) {
            String actor = queryMovie.replaceFirst("^DIR:","");
            return movieDao.getMovieByDIR(actor);
        }else{
            return movieDao.getMoviesByName(queryMovie);
        }
    }
    public static boolean isActor(String queryCus) {
        String actorRegex = "^AC:[\\w\\s]+$";  // ^AC: theo sau tên tác giả có thể chứa chữ cái và khoảng trắng
        return queryCus.matches(actorRegex);
    }
    public static boolean isDIR(String queryCus) {
        String actorRegex = "^DIR:[\\w\\s]+$";  // ^AC: theo sau tên tác giả có thể chứa chữ cái và khoảng trắng
        return queryCus.matches(actorRegex);
    }

}
