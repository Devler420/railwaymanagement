package com.boompanupong.railwaymanagement.repository;

import com.boompanupong.railwaymanagement.model.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
