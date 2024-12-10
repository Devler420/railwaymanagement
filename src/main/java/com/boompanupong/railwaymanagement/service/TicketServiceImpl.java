package com.boompanupong.railwaymanagement.service;

import com.boompanupong.railwaymanagement.exception.NotFoundException;
import com.boompanupong.railwaymanagement.model.Passenger;
import com.boompanupong.railwaymanagement.model.Ticket;
import com.boompanupong.railwaymanagement.model.Train;
import com.boompanupong.railwaymanagement.model.dto.TicketDto;
import com.boompanupong.railwaymanagement.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private TrainService trainService;

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
    public Ticket createTicket(TicketDto ticketDto) {
        Passenger passenger = passengerService.getPassengerById(ticketDto.getPassengerId());
        Train train = trainService.getTrainById(ticketDto.getTrainId());

        Ticket ticket = new Ticket();
        ticket.setPassenger(passenger);
        ticket.setTrain(train);
        ticket.setBookingDate(ticketDto.getBookingDate());
        ticket.setPrice(ticketDto.getPrice());
        ticket.setSeatNumber(ticketDto.getSeatNumber());

        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket updateTicket(TicketDto ticketDto) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketDto.getId());
        Ticket ticketToUpdate = optionalTicket.orElseThrow(() ->
                new NotFoundException("ticket ID: " + ticketDto.getId() + " Not Found"));

        Passenger newPassenger = passengerService.getPassengerById(ticketDto.getPassengerId());
        Train newTrain = trainService.getTrainById(ticketDto.getTrainId());

        ticketToUpdate.setPassenger(newPassenger);
        ticketToUpdate.setTrain(newTrain);
        ticketToUpdate.setBookingDate(ticketDto.getBookingDate());
        ticketToUpdate.setPrice(ticketDto.getPrice());
        ticketToUpdate.setSeatNumber(ticketDto.getSeatNumber());

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
