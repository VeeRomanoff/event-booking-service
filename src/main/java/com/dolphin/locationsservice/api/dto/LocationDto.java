package com.dolphin.locationsservice.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record LocationDto(
        @NotBlank(message = "name cannot be empty")
        String name,

        @NotBlank(message = "description cannot be empty")
        String description,

        @NotBlank(message = "address cannot be empty")
        String address,
        @Min(value = 1, message = "capacity must be greater than 0")
        int capacity
) {

    public LocationDto(String name, String description, String address, int capacity) {
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
        return "LocationDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
