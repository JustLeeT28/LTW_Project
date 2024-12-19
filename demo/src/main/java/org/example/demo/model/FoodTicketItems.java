package org.example.demo.model;

public class FoodTicketItems {
    private int id;
    private int foodTicketId;
    private int comboId;
    private int quantity;
    private double totalPrice;

    public FoodTicketItems(int id, int foodTicketId, int quantity, int comboId, double totalPrice) {
        this.id = id;
        this.foodTicketId = foodTicketId;
        this.quantity = quantity;
        this.comboId = comboId;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoodTicketId() {
        return foodTicketId;
    }

    public void setFoodTicketId(int foodTicketId) {
        this.foodTicketId = foodTicketId;
    }

    public int getComboId() {
        return comboId;
    }

    public void setComboId(int comboId) {
        this.comboId = comboId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
