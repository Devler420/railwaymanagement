package com.boompanupong.railwaymanagement.service;

import com.boompanupong.railwaymanagement.model.Station;

import java.util.List;

public interface StationService {
    List<Station> getAllStation();
    Station getStationById(Long id);
    Station createStation(Station station);
}
