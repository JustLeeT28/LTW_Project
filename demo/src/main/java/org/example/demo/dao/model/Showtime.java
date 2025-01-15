package org.example.demo.dao.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class Showtime {
    private int id;
    private int movieId;
    private int roomId;
    private String roomName;
    private LocalDate showDate;
    private LocalTime showTime;
    private String status;



    // Constructor đầy đủ
    public Showtime(int id, int movieId, int roomId, LocalDate showDate, LocalTime showTime, String status) {
        this.id = id;
        this.movieId = movieId;
        this.roomId = roomId;
        this.showDate = showDate;
        this.showTime = showTime;
        this.status = status;
    }

    public Showtime(int movieId, int roomId,LocalDate showDate, LocalTime showTime, String status) {
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
                ", roomId=" + roomId +
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
