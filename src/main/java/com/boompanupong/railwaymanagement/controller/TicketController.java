package com.boompanupong.railwaymanagement.controller;

import com.boompanupong.railwaymanagement.model.Ticket;
import com.boompanupong.railwaymanagement.model.dto.TicketDto;
import com.boompanupong.railwaymanagement.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/railwaymanager/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTicket() {
        List<Ticket> response = ticketService.getAllTicket();
        return response.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Ticket response = ticketService.getTicketById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody TicketDto ticketDto) {
        Ticket savedTicket = ticketService.createTicket(ticketDto);
        return new ResponseEntity<>(savedTicket, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Ticket> updateTicket(@RequestBody TicketDto ticketDto) {
        Ticket updateTicket = ticketService.updateTicket(ticketDto);
        return new ResponseEntity<>(updateTicket, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public void deleteTicketById(@PathVariable Long id) {
        ticketService.deleteTicketById(id);
    }
}
