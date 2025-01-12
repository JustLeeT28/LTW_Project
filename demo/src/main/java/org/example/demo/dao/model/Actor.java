package org.example.demo.dao.model;

public class Actor {
    private int id;
    private String name;

    public Actor(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Actor() {
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
