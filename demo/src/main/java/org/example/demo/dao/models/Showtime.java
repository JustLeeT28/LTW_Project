package org.example.demo.dao.models;

import java.sql.Date;
import java.sql.Time;

public class Showtime {
    private int id;
    private int movieId;
    private String movieTitle;
    private int roomId;
    private String roomName;
    private String showDate;
    private String showTime;
    private String status;

    // Constructor đầy đủ
    public Showtime(int id, int movieId, String movieTitle, int roomId, String roomName, String showDate, String showTime, String status) {
        this.id = id;
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.roomId = roomId;
        this.roomName = roomName;
        this.showDate = showDate;
        this.showTime = showTime;
        this.status = status;
    }

    // Constructor không ID (khi thêm mới)
    public Showtime(int movieId, String movieTitle, int roomId, String roomName, String showDate, String showTime, String status) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.roomId = roomId;
        this.roomName = roomName;
        this.showDate = showDate;
        this.showTime = showTime;
        this.status = status;
    }

    // Getters và Setters
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

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Showtime{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", movieTitle='" + movieTitle + '\'' +
                ", roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", showDate=" + showDate +
                ", showTime=" + showTime +
                ", status='" + status + '\'' +
                '}';
    }
}
