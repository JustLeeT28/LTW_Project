package org.example.demo.dao.model;

public class Director {
    private int id;
    private String name;

    public Director(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Director() {
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
}
