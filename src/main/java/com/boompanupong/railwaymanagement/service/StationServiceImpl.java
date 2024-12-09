package com.boompanupong.railwaymanagement.service;

import com.boompanupong.railwaymanagement.exception.NotFoundException;
import com.boompanupong.railwaymanagement.model.Station;
import com.boompanupong.railwaymanagement.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StationServiceImpl implements StationService {

    @Autowired
    private StationRepository stationRepository;

    @Override
    public List<Station> getAllStation() {
        return (List<Station>) stationRepository.findAll();
    }

    @Override
    public Station getStationById(Long id) {
        Optional<Station> optionalStation = stationRepository.findById(id);
        return optionalStation.orElseThrow(() -> new NotFoundException("Station Not Found"));
    }

    @Override
    public Station createStation(Station station) {
        System.out.println("Station Saved");
        return stationRepository.save(station);
    }
}
