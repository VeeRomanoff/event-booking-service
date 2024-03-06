package com.dolphin.locationsservice.api.domain;

public class Location {

    private final String name;
    private final String description;
    private final String address;
    private final int capacity;

    public Location(String name, String description, String address, int capacity) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
