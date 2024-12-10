package com.boompanupong.railwaymanagement.service;

import com.boompanupong.railwaymanagement.model.Train;
import com.boompanupong.railwaymanagement.model.dto.TrainDto;

import java.util.List;

public interface TrainService {
    List<Train> getAllTrain();
    Train getTrainById(Long id);
    Train createTrain(TrainDto trainDto);
    Train updateTrain(TrainDto trainDto);
    void deleteTrainById(Long id);
}
