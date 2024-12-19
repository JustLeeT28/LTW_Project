package org.example.demo.model;

public class Orders {
    private int id;
    private int userId;
    private double totalAmount;
    private String orderDate;
    private Integer foodTicketId; // Nullable

    public Orders(int id, int userId, double totalAmount, String orderDate, Integer foodTicketId) {
        this.id = id;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.foodTicketId = foodTicketId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getFoodTicketId() {
        return foodTicketId;
    }

    public void setFoodTicketId(Integer foodTicketId) {
        this.foodTicketId = foodTicketId;
    }
}
