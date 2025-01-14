package org.example.demo.service;

import org.example.demo.dao.AddMovieDao;

public class AddMovieService {
    AddMovieDao addMovieDao = new AddMovieDao();
    public int addMovie(String title, String posterUrl, String bannerUrl, String description, String country, String language, String subtitle, String ageRating, String releaseDate, String endDate,String duration) {
        return addMovieDao.addMovie(title,posterUrl,bannerUrl,description,country,language,subtitle,ageRating,releaseDate,endDate,duration);
    }

    public void addGenre_movie(String genre,int movie_newid) {
        addMovieDao.addGenre_movie(genre,movie_newid);
    }
}
