package com.boompanupong.railwaymanagement.controller;

import com.boompanupong.railwaymanagement.model.Station;
import com.boompanupong.railwaymanagement.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/station")
public class StationController {
    @Autowired
    private StationService stationService;

    @GetMapping
    public ResponseEntity<List<Station>> getAllStation() {
        List<Station> response = stationService.getAllStation();
        return response.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Station> getStationById(@PathVariable Long id) {
        Station response = stationService.getStationById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Station> createStation(@RequestBody Station station) {
        Station savedStation = stationService.createStation(station);
        return new ResponseEntity<>(savedStation, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Station> updateStation(@RequestBody Station station) {
        Station updateStation = stationService.updateStation(station);
        return new ResponseEntity<>(updateStation, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public void deleteStationById(@PathVariable Long id) {
        stationService.deleteStationById(id);
    }
}
