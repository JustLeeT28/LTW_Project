package org.example.demo.dao.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class Showtime {
    private int id;
    private int movieId;
    private String movieTitle;
    private int roomId;
    private String roomName;
    private LocalDate showDate;
    private LocalTime showTime;
    private String status;


    public Showtime(int id, int movieId, int roomId, LocalDate showDate, LocalTime showTime, String status) {
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
    public Showtime(int movieId, String movieTitle, int roomId, String roomName, LocalDate showDate, LocalTime showTime, String status) {
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

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalTime showTime) {
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

    public String getDayOfWeek() {
        DayOfWeek dayOfWeek = showDate.getDayOfWeek();
        String dayOfWeekInVietnamese;
        switch (dayOfWeek) {
            case MONDAY:
                dayOfWeekInVietnamese = "Thứ Hai";
                break;
            case TUESDAY:
                dayOfWeekInVietnamese = "Thứ Ba";
                break;
            case WEDNESDAY:
                dayOfWeekInVietnamese = "Thứ Tư";
                break;
            case THURSDAY:
                dayOfWeekInVietnamese = "Thứ Năm";
                break;
            case FRIDAY:
                dayOfWeekInVietnamese = "Thứ Sáu";
                break;
            case SATURDAY:
                dayOfWeekInVietnamese = "Thứ Bảy";
                break;
            case SUNDAY:
                dayOfWeekInVietnamese = "Chủ Nhật";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + dayOfWeek);
        }
        return dayOfWeekInVietnamese;
    }

    public int getHour() {
        return showTime.getHour();
    }

    public int getMinute() {
        return showTime.getMinute();
    }
    public int getMonth() {
        return showDate.getMonthValue();
    }
    public int getDay() {
        return showDate.getDayOfMonth();
    }
    public int getYear() {
        return showDate.getYear();
    }

}
