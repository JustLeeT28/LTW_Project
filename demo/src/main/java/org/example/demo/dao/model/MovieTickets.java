package org.example.demo.dao.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MovieTickets {
    private int id;
    private int showTimeId;
    private int seatId;
    private double price;
    private String createdAt;
    private int userId;
    private String titleMovie;
    private String roomId;
    private String seatRow;
    private String seatNum;
    private LocalDate dateShow;
    private LocalTime timeShow;



    public MovieTickets() {
    }

    public MovieTickets(int id, int showTimeId, int seatId, double price, String createdAt, int userId) {
        this.id = id;
        this.showTimeId = showTimeId;
        this.seatId = seatId;
        this.price = price;
        this.createdAt = createdAt;
        this.userId = userId;
    }

    public MovieTickets( double price,
                        String titleMovie, String roomId, String seatRow, String seatNum,
                        LocalDate dateShow, LocalTime timeShow) {
        this.price = price;
        this.titleMovie = titleMovie;
        this.roomId = roomId;
        this.seatRow = seatRow;
        this.seatNum = seatNum;
        this.dateShow = dateShow;
        this.timeShow = timeShow;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShowTimeId() {
        return showTimeId;
    }

    public void setShowTimeId(int showTimeId) {
        this.showTimeId = showTimeId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitleMovie() {
        return titleMovie;
    }

    public void setTitleMovie(String titleMovie) {
        this.titleMovie = titleMovie;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(String seatRow) {
        this.seatRow = seatRow;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public LocalDate getDateShow() {
        return dateShow;
    }

    public void setDateShow(LocalDate dateShow) {
        this.dateShow = dateShow;
    }

    public LocalTime getTimeShow() {
        return timeShow;
    }

    public void setTimeShow(LocalTime timeShow) {
        this.timeShow = timeShow;
    }

//    public String  getLocalSeat(){
//        String localSeat = getRoomId()+"-"+ getSeatRow() + "-" + getSeatNum();
//        return localSeat;
//    }

    public String getFormattedShowtime() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        String formattedDate = (dateShow != null) ? dateShow.format(dateFormatter) : "N/A";
        String formattedTime = (timeShow != null) ? timeShow.format(timeFormatter) : "N/A";

        return formattedDate + " " + formattedTime;
    }




    @Override
    public String toString() {
        return "MovieTickets{" +
                "id=" + id +
                ", showTimeId=" + showTimeId +
                ", seatId=" + seatId +
                ", price=" + price +
                ", createdAt='" + createdAt + '\'' +
                ", userId=" + userId +
                '}';
    }
}
