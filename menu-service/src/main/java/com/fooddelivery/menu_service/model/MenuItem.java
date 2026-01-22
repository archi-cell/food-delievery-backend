package com.fooddelivery.menu_service.model;

public class MenuItem {
    private int id;
    private String name;
    private double price;

    public MenuItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters and setters (needed for JSON response)
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}
