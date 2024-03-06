package com.dolphin.locationsservice.api.service;

import com.dolphin.locationsservice.api.converter.LocationConverter;
import com.dolphin.locationsservice.api.domain.Location;
import com.dolphin.locationsservice.store.entity.LocationEntity;
import com.dolphin.locationsservice.store.repositories.LocationRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    public List<Location> getLocations() {
        List<LocationEntity> locations = repository.findAll();

        return locations.stream()
                .map(LocationConverter::fromEntityToLocation)
                .toList();
    }

    public Location getLocationById(Long id) {
        return repository.findById(id)
                .map(LocationConverter::fromEntityToLocation)
                .orElseThrow(() -> new EntityNotFoundException("Location doesn't exist"));
    }

    public Location createLocation(Location location) {
        LocationEntity locationEntity = LocationConverter.fromLocationToEntity(location);
        LocationEntity locationEntitySaved = repository.save(locationEntity);

        return LocationConverter.fromEntityToLocation(locationEntitySaved);
    }

    public void updateLocationById(Long id, Location location) {
        LocationEntity locationEntity = getLocationEntityOrEntityNotFoundException(id, location);

        BeanUtils.copyProperties(location, locationEntity, "id");

        repository.save(locationEntity);
    }

    public void deleteLocationById(Long id) {
        LocationEntity locationEntity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Location doesn't exist"));

        repository.deleteById(locationEntity.getId());
    }

    private LocationEntity getLocationEntityOrEntityNotFoundException(Long id, Location location) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Location doesn't exist"));
    }
}
