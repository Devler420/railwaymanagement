package com.boompanupong.railwaymanagement.controller;

import com.boompanupong.railwaymanagement.model.Train;
import com.boompanupong.railwaymanagement.model.dto.TrainDto;
import com.boompanupong.railwaymanagement.service.TrainService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/railwaymanager/train")
@Tag(name = "Train Management", description = "Endpoints for managing trains")
public class TrainController {

    @Autowired
    private TrainService trainService;
    @Operation(summary = "Get all trains", description = "Retrieve a list of all available trains.")
    @GetMapping
    public ResponseEntity<List<Train>> getAllTrain() {
        List<Train> response = trainService.getAllTrain();
        return response.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(response);
    }

    @Operation(summary = "Get train by ID", description = "Retrieve details of a specific train by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Train> getTrainById(@PathVariable Long id) {
        Train response = trainService.getTrainById(id);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Create a new train", description = "Add a new train to the system.")
    @PostMapping
    public ResponseEntity<Train> createTrain(@RequestBody TrainDto trainDto) {
        Train savedTrain = trainService.createTrain(trainDto);
        return new ResponseEntity<>(savedTrain, HttpStatus.CREATED);
    }

    @Operation(summary = "Update a train", description = "Update details of an existing train.")
    @PutMapping
    public ResponseEntity<Train> updateTrain(@RequestBody TrainDto trainDto) {
        Train updateTrain = trainService.updateTrain(trainDto);
        return new ResponseEntity<>(updateTrain, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Delete a train", description = "Remove a train from the system.")
    @DeleteMapping("/{id}")
    public void deleteTrainById(@PathVariable Long id) {
        trainService.deleteTrainById(id);
    }
}
