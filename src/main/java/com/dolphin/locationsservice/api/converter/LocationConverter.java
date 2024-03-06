package com.dolphin.locationsservice.api.converter;

import com.dolphin.locationsservice.api.domain.Location;
import com.dolphin.locationsservice.api.dto.LocationDto;
import com.dolphin.locationsservice.store.entity.LocationEntity;

public class LocationConverter {

    public static LocationEntity fromLocationToEntity(Location location) {
        LocationEntity locationEntity = new LocationEntity(
                location.getName(),
                location.getDescription(),
                location.getAddress(),
                location.getCapacity());

        return locationEntity;
    }

    public static LocationDto fromLocationToDto(Location location) {
        LocationDto locationDto = new LocationDto(
                location.getName(),
                location.getDescription(),
                location.getAddress(),
                location.getCapacity());

        return locationDto;
    }

    public static Location fromDtoToLocation(LocationDto locationDto) {
        Location location = new Location(
                locationDto.getName(),
                locationDto.getDescription(),
                locationDto.getAddress(),
                locationDto.getCapacity());

        return location;
    }

    public static Location fromEntityToLocation(LocationEntity locationEntity) {
        Location location = new Location(
                locationEntity.getName(),
                locationEntity.getDescription(),
                locationEntity.getAddress(),
                locationEntity.getCapacity());

        return location;
    }
}
