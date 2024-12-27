package org.example.demo.dao.models;

public class Room {
    private int id;
    private String name;
    private String style;
    private int occupancy;
    private String status;

    public Room(int id, String name, String style, int occupancy, String status) {
        this.id = id;
        this.name = name;
        this.style = style;
        this.occupancy = occupancy;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
