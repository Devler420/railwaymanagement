package com.boompanupong.railwaymanagement.service;

import com.boompanupong.railwaymanagement.model.Ticket;
import com.boompanupong.railwaymanagement.model.dto.TicketDto;

import java.util.List;

public interface TicketService {
    List<Ticket> getAllTicket();
    Ticket getTicketById(Long id);
    Ticket createTicket(TicketDto ticketDto);
    Ticket updateTicket(TicketDto ticketDto);
    void deleteTicketById(Long id);
}
