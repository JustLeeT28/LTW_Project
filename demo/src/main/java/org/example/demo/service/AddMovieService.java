package org.example.demo.service;

import org.example.demo.dao.AddMovieDao;

public class AddMovieService {
    AddMovieDao addMovieDao = new AddMovieDao();
    public int addMovie(String title, String posterUrl, String bannerUrl, String description, String country, String language, String subtitle, String ageRating, String releaseDate, String endDate,String duration, String trailerUrl) {
        return addMovieDao.addMovie(title,posterUrl,bannerUrl,description,country,language,subtitle,ageRating,releaseDate,endDate,duration,trailerUrl);
    }

    public void addGenre_movie(String genre,int movie_newid) {
        addMovieDao.addGenre_movie(genre,movie_newid);
    }

    public void addDirector_movie(String directors, int movieNewid) {
        addMovieDao.addDirector_movie(directors,movieNewid);
    }

    public void addActor_movie(String actors, int movieNewid) {
        addMovieDao.addActor_movie(actors,movieNewid);
    }

    public void delMovie(String delMovie) {
        addMovieDao.deleteMovie(delMovie);
    }
}
