package com.example.demo12.model;

public class Location {
    private int id;
    private String nameLocation;
    private String painted;
    private int capacity;
    private int amount;

    public Location() {
    }

    public Location(String nameLocation, String painted, int capacity, int amount) {
        this.nameLocation = nameLocation;
        this.painted = painted;
        this.capacity = capacity;
        this.amount = amount;
    }

    public Location(int id, String nameLocation, String painted, int capacity, int amount) {
        this.id = id;
        this.nameLocation = nameLocation;
        this.painted = painted;
        this.capacity = capacity;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameLocation() {
        return nameLocation;
    }

    public void setNameLocation(String nameLocation) {
        this.nameLocation = nameLocation;
    }

    public String getPainted() {
        return painted;
    }

    public void setPainted(String painted) {
        this.painted = painted;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nameLocation='" + nameLocation + '\'' +
                ", painted='" + painted + '\'' +
                ", capacity=" + capacity +
                ", amount=" + amount +
                '}';
    }
}
