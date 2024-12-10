package com.boompanupong.railwaymanagement.service;

import com.boompanupong.railwaymanagement.model.Passenger;

import java.util.List;

public interface PassengerService {
    List<Passenger> getAllPassenger();
    Passenger getPassengerById(Long id);
}
