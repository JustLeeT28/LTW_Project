package org.example.demo.model;

public class MovieTicket {
    private int id;
    private int orderId;
    private int seatId;
    private double ticketPrice;
    private String createdDate;

    public MovieTicket(int id, int orderId, int seatId, double ticketPrice, String createdDate) {
        this.id = id;
        this.orderId = orderId;
        this.seatId = seatId;
        this.ticketPrice = ticketPrice;
        this.createdDate = createdDate;
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

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
