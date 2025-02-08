package org.example.demo.dao.model;

import java.util.List;

public class Seat {
    private int id;
    private int roomId;
    private String row;
    private String seatNumber;
    private double price;
    private String isActive;
    private boolean isSelected;

    public Seat(int id, int roomId, String row, String seatNumber, double price, String isActive) {
        this.id = id;
        this.roomId = roomId;
        this.row = row;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIsActive() {
        return isActive;
    }

    public String getStringid(){
        String id = String.valueOf(this.id);
        return id;
    }
    public boolean contain(List<String> seatStrings){
        String currentId = String.valueOf(this.id);
        for(String seatString : seatStrings){
            if(currentId.equals(seatString)){
                return true;
            }
        }
        return false;
    }
    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
}
