package com.boompanupong.railwaymanagement.service;

import com.boompanupong.railwaymanagement.exception.NotFoundException;
import com.boompanupong.railwaymanagement.model.Train;
import com.boompanupong.railwaymanagement.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainRepository trainRepository;

    @Override
    public List<Train> getAllTrain() {
        return (List<Train>) trainRepository.findAll();
    }

    @Override
    public Train getTrainById(Long id) {
        Optional<Train> optionalTrain = trainRepository.findById(id);
        return optionalTrain.orElseThrow(() ->
                new NotFoundException("Train ID: " + id + " Not Found"));
    }

    @Override
    public Train createTrain(Train train) {
        return trainRepository.save(train);
    }

    @Override
    public Train updateTrain(Train train) {
        Optional<Train> optionalTrain = trainRepository.findById(train.getId());
        Train trainToUpdate = optionalTrain.orElseThrow(() ->
                new NotFoundException("Train ID: " + train.getId() + " Not Found"));
        trainToUpdate.setTrainNumber(train.getTrainNumber());
        trainToUpdate.setDepartureTime(train.getDepartureTime());
        trainToUpdate.setArrivalTime(train.getArrivalTime());
        trainToUpdate.setOriginStation(train.getOriginStation());
        trainToUpdate.setDestinationStation(train.getDestinationStation());
        trainToUpdate.setSeatCapacity(train.getSeatCapacity());
        trainToUpdate.setTicketPrice(train.getTicketPrice());
        return trainRepository.save(trainToUpdate);
    }

    @Override
    public void deleteTrainById(Long id) {
        Optional<Train> optionalTrainToDelete = trainRepository.findById(id);
        if (optionalTrainToDelete.isPresent()) {
            trainRepository.deleteById(id);
        } else {
            throw new NotFoundException("Train ID: " + id + " Not Found");
        }
    }
}
