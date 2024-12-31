package org.example.demo.dao.models;

public class MovieTicket {
    private int id;
    private int orderId;
    private int showTimeId;
    private int seatId;
    private double price;
    private String createdAt;
    private String customerName;
    private String seat;
    private String showtime;

    public MovieTicket(int id, int orderId, int showTimeId, int seatId, double price, String createdAt, String customerName, String seat, String showtime) {
        this.id = id;
        this.orderId = orderId;
        this.showTimeId = showTimeId;
        this.seatId = seatId;
        this.price = price;
        this.createdAt = createdAt;
        this.customerName = customerName;
        this.seat = seat;
        this.showtime = showtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }
}
