package com.dolphin.locationsservice.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class LocationDto {

    @NotBlank(message = "name cannot be empty")
    private String name;

    @NotBlank(message = "description cannot be empty")
    private String description;

    @NotBlank(message = "address cannot be empty")
    private String address;
    @Min(value = 1, message = "capacity must be greater than 0")
    private int capacity;

    public LocationDto(String name, String description, String address, int capacity) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "LocationDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
