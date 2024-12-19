package org.example.demo.model;

public class FoodTickets {
    private int id;
    private double totalAmount;

    public FoodTickets(double totalAmount, int id) {
        this.totalAmount = totalAmount;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
