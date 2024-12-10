package com.boompanupong.railwaymanagement.service;

import com.boompanupong.railwaymanagement.exception.NotFoundException;
import com.boompanupong.railwaymanagement.model.Station;
import com.boompanupong.railwaymanagement.model.Train;
import com.boompanupong.railwaymanagement.model.dto.TrainDto;
import com.boompanupong.railwaymanagement.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private StationService stationService;

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
    public Train createTrain(TrainDto trainDto) {
        Station originStation = stationService.getStationById(trainDto.getOriginStationId());
        Station destinationStation = stationService.getStationById(trainDto.getDestinationStationId());

        Train train = new Train();
        train.setTrainNumber(trainDto.getTrainNumber());
        train.setDepartureTime(trainDto.getDepartureTime());
        train.setArrivalTime(trainDto.getArrivalTime());
        train.setOriginStation(originStation);
        train.setDestinationStation(destinationStation);
        train.setSeatCapacity(trainDto.getSeatCapacity());
        train.setTicketPrice(trainDto.getTicketPrice());

        return trainRepository.save(train);
    }

    @Override
    public Train updateTrain(TrainDto trainDto) {
        Optional<Train> optionalTrain = trainRepository.findById(trainDto.getId());
        Train trainToUpdate = optionalTrain.orElseThrow(() ->
                new NotFoundException("Train ID: " + trainDto.getId() + " Not Found"));

        Station newOriginStation = stationService.getStationById(trainDto.getOriginStationId());
        Station newDestinationStation = stationService.getStationById(trainDto.getDestinationStationId());

        trainToUpdate.setTrainNumber(trainDto.getTrainNumber());
        trainToUpdate.setDepartureTime(trainDto.getDepartureTime());
        trainToUpdate.setArrivalTime(trainDto.getArrivalTime());
        trainToUpdate.setOriginStation(newOriginStation);
        trainToUpdate.setDestinationStation(newDestinationStation);
        trainToUpdate.setSeatCapacity(trainDto.getSeatCapacity());
        trainToUpdate.setTicketPrice(trainDto.getTicketPrice());

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
