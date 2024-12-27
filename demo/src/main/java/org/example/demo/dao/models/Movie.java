package org.example.demo.dao.models;

public class Movie {
    private int id;
    private String title;
    private int duration;
    private String description;
    private String country;
    private String language;
    private String subtitle;
    private String ageRating;
    private String releaseDate;
    private String endDate;
    private String bannerUrl;
    private String posterUrl;
    private String status;

    public Movie(int id, String title, int duration, String description, String country, String language, String subtitle, String ageRating, String releaseDate, String endDate, String bannerUrl, String posterUrl, String status) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.description = description;
        this.country = country;
        this.language = language;
        this.subtitle = subtitle;
        this.ageRating = ageRating;
        this.releaseDate = releaseDate;
        this.endDate = endDate;
        this.bannerUrl = bannerUrl;
        this.posterUrl = posterUrl;
        this.status = status;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
