package com.boompanupong.railwaymanagement.service;

import com.boompanupong.railwaymanagement.model.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> getAllTickets();
    Ticket getTicketById();
    Void createTicket();
}
