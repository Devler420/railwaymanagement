package com.boompanupong.railwaymanagement.repository;

import com.boompanupong.railwaymanagement.model.Train;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends CrudRepository<Train, Long> {
}
