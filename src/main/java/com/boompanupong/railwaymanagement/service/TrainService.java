package com.boompanupong.railwaymanagement.service;

import com.boompanupong.railwaymanagement.model.Train;

import java.util.List;

public interface TrainService {
    List<Train> getAllTrain();
    Train getTrainById(Long id);
    Train createTrain(Train train);
    Train updateTrain(Train train);
    void deleteTrainById(Long id);
}
