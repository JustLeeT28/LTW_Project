package org.example.demo.model;

public class Showtimes {
    private int id;
    private int movieId;
    private String date;
    private String time;
    private int roomId;

    public Showtimes(int id, int movieId, String date, String time, int roomId) {
        this.id = id;
        this.movieId = movieId;
        this.date = date;
        this.time = time;
        this.roomId = roomId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
