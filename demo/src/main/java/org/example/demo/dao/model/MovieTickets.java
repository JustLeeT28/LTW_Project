package org.example.demo.dao.model;

public class MovieTickets {
    private int id;
    private int showTimeId;
    private int seatId;
    private double price;
    private String createdAt;
    private int userId;

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
