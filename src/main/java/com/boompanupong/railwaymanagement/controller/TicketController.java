package com.boompanupong.railwaymanagement.controller;

import com.boompanupong.railwaymanagement.model.Ticket;
import com.boompanupong.railwaymanagement.model.dto.TicketDto;
import com.boompanupong.railwaymanagement.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/railwaymanager/ticket")
@Tag(name = "Ticket Management", description = "Endpoints for managing tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Operation(summary = "Get all tickets", description = "Retrieve a list of all available tickets.")
    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTicket() {
        List<Ticket> response = ticketService.getAllTicket();
        return response.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(response);
    }

    @Operation(summary = "Get ticket by ID", description = "Retrieve details of a specific ticket by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Ticket response = ticketService.getTicketById(id);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Create a new ticket", description = "Add a new ticket to the system.")
    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody TicketDto ticketDto) {
        Ticket savedTicket = ticketService.createTicket(ticketDto);
        return new ResponseEntity<>(savedTicket, HttpStatus.CREATED);
    }

    @Operation(summary = "Update a ticket", description = "Update details of an existing ticket.")
    @PutMapping
    public ResponseEntity<Ticket> updateTicket(@RequestBody TicketDto ticketDto) {
        Ticket updateTicket = ticketService.updateTicket(ticketDto);
        return new ResponseEntity<>(updateTicket, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Delete a ticket", description = "Remove a ticket from the system.")
    @DeleteMapping("/{id}")
    public void deleteTicketById(@PathVariable Long id) {
        ticketService.deleteTicketById(id);
    }
}
