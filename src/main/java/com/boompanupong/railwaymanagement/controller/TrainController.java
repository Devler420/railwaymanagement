package com.boompanupong.railwaymanagement.controller;

import com.boompanupong.railwaymanagement.model.Train;
import com.boompanupong.railwaymanagement.model.dto.TrainDto;
import com.boompanupong.railwaymanagement.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/railwaymanager/train")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @GetMapping
    public ResponseEntity<List<Train>> getAllTrain() {
        List<Train> response = trainService.getAllTrain();
        return response.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Train> getTrainById(@PathVariable Long id) {
        Train response = trainService.getTrainById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Train> createTrain(@RequestBody TrainDto trainDto) {
        Train savedTrain = trainService.createTrain(trainDto);
        return new ResponseEntity<>(savedTrain, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Train> updateTrain(@RequestBody TrainDto trainDto) {
        Train updateTrain = trainService.updateTrain(trainDto);
        return new ResponseEntity<>(updateTrain, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public void deleteTrainById(@PathVariable Long id) {
        trainService.deleteTrainById(id);
    }
}
