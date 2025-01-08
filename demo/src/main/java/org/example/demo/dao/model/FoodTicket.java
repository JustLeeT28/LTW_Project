package org.example.demo.dao.model;

public class FoodTicket {
    private int id;
    private double totalPrice;

    public FoodTicket(int id, double totalPrice) {
        this.id = id;
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
