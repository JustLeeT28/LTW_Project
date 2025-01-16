package org.example.demo.dao.model;

public class FoodTicketItem {
    private int id;
    private int comboId;
    private int userId;
    private int quantity;
    private double totalPrice;

    public FoodTicketItem(int id, int comboId, int quantity, double totalPrice, int userId) {
        this.id = id;
        this.comboId = comboId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.userId = userId;
    }
    public FoodTicketItem( int comboId, int quantity, double totalPrice, int userId) {
        this.comboId = comboId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.userId = userId;
    }
    public FoodTicketItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
