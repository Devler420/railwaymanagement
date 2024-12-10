package com.boompanupong.railwaymanagement.service;

import com.boompanupong.railwaymanagement.exception.NotFoundException;
import com.boompanupong.railwaymanagement.model.Ticket;
import com.boompanupong.railwaymanagement.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> getAllTicket() {
        return (List<Ticket>) ticketRepository.findAll();
    }

    @Override
    public Ticket getTicketById(Long id) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        return optionalTicket.orElseThrow(() ->
                new NotFoundException("Ticket ID: " + id + " Not Found"));
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket updateTicket(Ticket ticket) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticket.getId());
        Ticket ticketToUpdate = optionalTicket.orElseThrow(() ->
                new NotFoundException("ticket ID: " + ticket.getId() + " Not Found"));
        ticketToUpdate.setBookingDate(ticket.getBookingDate());
        ticketToUpdate.setTrain(ticket.getTrain());
        ticketToUpdate.setPrice(ticket.getPrice());
        ticketToUpdate.setSeatNumber(ticket.getSeatNumber());
        return ticketRepository.save(ticketToUpdate);
    }

    @Override
    public void deleteTicketById(Long id) {
        Optional<Ticket> optionalTicketToDelete = ticketRepository.findById(id);
        if (optionalTicketToDelete.isPresent()) {
            ticketRepository.deleteById(id);
        } else {
            throw new NotFoundException("Ticket ID: " + id + " Not Found");
        }
    }
}
