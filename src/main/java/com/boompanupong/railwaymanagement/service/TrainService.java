package com.boompanupong.railwaymanagement.service;

import com.boompanupong.railwaymanagement.model.Train;

import java.util.List;

public interface TrainService {
    List<Train> getAllTrain();
    Train getTrainById();
    Train createTrain();
}
