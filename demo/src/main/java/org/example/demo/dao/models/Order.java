package org.example.demo.dao.models;

public class Order {
    private int id;
    private int userId;
    private double totalPrice;
    private String orderDate;
    private Integer foodTicketId;

    public Order(int id, int userId, double totalPrice, String orderDate, Integer foodTicketId) {
        this.id = id;
        this.userId = userId;
        this.totalPrice = totalPrice;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
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
