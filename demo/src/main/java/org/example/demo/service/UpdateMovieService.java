package org.example.demo.service;

import org.example.demo.dao.AddMovieDao;
import org.example.demo.dao.UpdateMovieDao;

public class UpdateMovieService {
    UpdateMovieDao updateMovieDao = new UpdateMovieDao();
    public void updateTitle(int movieId, String title) {
        updateMovieDao.updateTitle(movieId,title);
    }

    public void updatePosterUrl(int movieId, String posterUrl) {
        updateMovieDao.updatePosterUrl(movieId,posterUrl);
    }

    public void updateBannerUrl(int movieId, String bannerUrl) {
        updateMovieDao.updateBannerUrl(movieId,bannerUrl);
    }

    public void updateDescription(int movieId, String description) {
        updateMovieDao.updateDescription(movieId,description);
    }

    public void updateCountry(int movieId, String country) {
        updateMovieDao.updateCountry(movieId,country);
    }

    public void updateLanguage(int movieId, String language) {
        updateMovieDao.updateLanguage(movieId,language);
    }

    public void updateSubtitle(int movieId, String subtitle) {
        updateMovieDao.updateSubtitle(movieId,subtitle);
    }

    public void updateDuration(int movieId, String duration) {
        updateMovieDao.updateDuration(movieId,duration);
    }

    public void updateAgeRating(int movieId, String ageRating) {
        updateMovieDao.updateAgeRating(movieId,ageRating);
    }

    public void updateReleaseDate(int movieId, String releaseDate) {
        updateMovieDao.updateReleaseDate(movieId,releaseDate);
    }

    public void updateEndDate(int movieId, String endDate) {
        updateMovieDao.updateEndDate(movieId,endDate);
    }

    public void updateGenres(int movieId, String genres) {
        updateMovieDao.updateGenres(movieId,genres);

    }

    public void updateDirectors(int movieId, String directors) {
        updateMovieDao.updateDirectors(movieId,directors);
    }

    public void updateActors(int movieId, String actors) {
        updateMovieDao.updateActors(movieId,actors);

    }
}
