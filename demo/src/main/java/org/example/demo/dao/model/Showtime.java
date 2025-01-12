package org.example.demo.dao.model;

public class Showtime {
    private int id;
    private int movieId;
    private int roomId;
    private String showDate;
    private String showTime;
    private String status;

    // Constructor đầy đủ
    public Showtime(int id, int movieId, int roomId, String showDate, String showTime, String status) {
        this.id = id;
        this.movieId = movieId;
        this.roomId = roomId;
        this.showDate = showDate;
        this.showTime = showTime;
        this.status = status;
    }

    // Constructor không ID (khi thêm mới)
    public Showtime(int movieId, int roomId,String showDate, String showTime, String status) {
        this.movieId = movieId;
        this.roomId = roomId;
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

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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
                ", roomId=" + roomId +
                ", showDate=" + showDate +
                ", showTime=" + showTime +
                ", status='" + status + '\'' +
                '}';
    }
}
