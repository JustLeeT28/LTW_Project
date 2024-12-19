package org.example.demo.model;

public class Seats {
    private int id;
    private String seatNumber;
    private int showId;
    private double price;
    private String status; // Available, Reserved, Booked

    public Seats(int id, String seatNumber, int showId, double price, String status) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.showId = showId;
        this.price = price;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
