package com.boompanupong.railwaymanagement.repository;

import com.boompanupong.railwaymanagement.model.Passenger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends CrudRepository<Passenger, Long> {
}
