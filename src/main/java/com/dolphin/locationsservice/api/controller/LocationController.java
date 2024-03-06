package com.dolphin.locationsservice.api.controller;

import com.dolphin.locationsservice.api.converter.LocationConverter;
import com.dolphin.locationsservice.api.domain.Location;
import com.dolphin.locationsservice.api.dto.LocationDto;
import com.dolphin.locationsservice.api.service.LocationService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationService service;

    public LocationController(LocationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<LocationDto>> getAllLocations() {
        List<Location> locations = service.getLocations();

        List<LocationDto> locationDtos = locations.stream()
                .map(LocationConverter::fromLocationToDto)
                .toList();

        return ResponseEntity.ok(locationDtos);
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<LocationDto> getLocationById(@PathVariable("locationId") @Parameter(name = "locationId", required = true, example = "1")Long id) {
        Location location = service.getLocationById(id);
        LocationDto locationDto = LocationConverter.fromLocationToDto(location);

        return ResponseEntity.ok(locationDto);
    }

    @PostMapping
    public ResponseEntity<LocationDto> createLocation(@RequestBody @Valid LocationDto locationDto) {
        Location location = LocationConverter.fromDtoToLocation(locationDto);
        service.createLocation(location);

        return ResponseEntity.ok(locationDto);
    }

    @PutMapping("/{locationId}")
    public ResponseEntity<LocationDto> updateLocation(@PathVariable("locationId") Long id,
                                                      @RequestBody @Valid LocationDto locationDto) {
        Location location = LocationConverter.fromDtoToLocation(locationDto);
        service.updateLocationById(id, location);

        return ResponseEntity.ok(locationDto);
    }

    @DeleteMapping("/{locationId}")
    public ResponseEntity<LocationDto> deleteLocation(@PathVariable("locationId") Long id) {
        service.deleteLocationById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
