package org.example.demo.dao.model;

public class MovieTicket {
    private int id;
    private int orderId;
    private int showTimeId;
    private int seatId;
    private double price;
    private String createdAt;
    private String nameUser;

    public MovieTicket(int id, int orderId, int showTimeId, int seatId, double price, String createdAt) {
        this.id = id;
        this.orderId = orderId;
        this.showTimeId = showTimeId;
        this.seatId = seatId;
        this.price = price;
        this.createdAt = createdAt;
    }

//    public MovieTicket(int id, int orderId, int showTimeId, int seatId, double price, String createdAt, String name) {
//        this.id = id;
//        this.orderId = orderId;
//        this.seatId = seatId;
//        this.price = price;
//        this.createdAt = createdAt;
//        this.nameUser = name;
//
//    }

    public MovieTicket(int id, int orderId, int showTimeId, int seatId, double price, String createdAt, String nameUser) {
        this.id = id;
        this.orderId = orderId;
        this.showTimeId = showTimeId;
        this.seatId = seatId;
        this.price = price;
        this.createdAt = createdAt;
        this.nameUser = nameUser;
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

    public String getNameUser() {return nameUser;}
    public void setNameUser(String nameUser) {this.nameUser = nameUser;}

}
