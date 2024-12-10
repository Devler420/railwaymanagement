package com.boompanupong.railwaymanagement.controller;

import com.boompanupong.railwaymanagement.model.Station;
import com.boompanupong.railwaymanagement.service.StationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/railwaymanager/station")
@Tag(name = "Station Management", description = "Endpoints for managing stations")
public class StationController {
    @Autowired
    private StationService stationService;

    @Operation(summary = "Get all stations", description = "Retrieve a list of all available stations.")
    @GetMapping
    public ResponseEntity<List<Station>> getAllStation() {
        List<Station> response = stationService.getAllStation();
        return response.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(response);
    }

    @Operation(summary = "Get station by ID", description = "Retrieve details of a specific station by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Station> getStationById(@PathVariable Long id) {
        Station response = stationService.getStationById(id);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Create a new station", description = "Add a new station to the system.")
    @PostMapping
    public ResponseEntity<Station> createStation(@RequestBody Station station) {
        Station savedStation = stationService.createStation(station);
        return new ResponseEntity<>(savedStation, HttpStatus.CREATED);
    }

    @Operation(summary = "Update a station", description = "Update details of an existing station.")
    @PutMapping
    public ResponseEntity<Station> updateStation(@RequestBody Station station) {
        Station updateStation = stationService.updateStation(station);
        return new ResponseEntity<>(updateStation, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Delete a station", description = "Remove a train from the system.")
    @DeleteMapping("/{id}")
    public void deleteStationById(@PathVariable Long id) {
        stationService.deleteStationById(id);
    }
}
