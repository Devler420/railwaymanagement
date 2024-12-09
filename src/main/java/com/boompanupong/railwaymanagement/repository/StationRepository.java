package com.boompanupong.railwaymanagement.repository;

import com.boompanupong.railwaymanagement.model.Station;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends CrudRepository<Station, Long> {
}
