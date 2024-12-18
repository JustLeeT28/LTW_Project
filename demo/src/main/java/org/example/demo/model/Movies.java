package org.example.demo.model;

public class Movies {
    private int id;
    private String title;
    private String director;
    private int duration;
    private String actors;
    private String description;
    private String genre;
    private String ageRating;
    private String releaseDate;
    private String endDate;
    private String bannerUrl;
    private String posterUrl;

    public Movies(String posterUrl, String bannerUrl, String endDate, String releaseDate, String ageRating, String genre, String description, String actors, int duration, String director, String title, int id) {
        this.posterUrl = posterUrl;
        this.bannerUrl = bannerUrl;
        this.endDate = endDate;
        this.releaseDate = releaseDate;
        this.ageRating = ageRating;
        this.genre = genre;
        this.description = description;
        this.actors = actors;
        this.duration = duration;
        this.director = director;
        this.title = title;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
}
