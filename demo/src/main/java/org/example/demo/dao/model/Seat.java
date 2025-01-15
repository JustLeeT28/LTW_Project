package org.example.demo.dao.model;

public class Seat {
    private int id;
    private int roomId;
    private String row;
    private String seatNumber;
    private double price;
    private String isActive;

    public Seat(int id, int roomId, String row, String seatNumber, double price, String isActive) {
        this.id = id;
        this.roomId = roomId;
        this.row = row;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
}
