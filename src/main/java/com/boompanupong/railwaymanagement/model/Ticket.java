package com.boompanupong.railwaymanagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    @Column(name = "booking_date")
    private LocalDateTime bookingDate;

    @Column(name = "price")
    private Double price;

    @Column(name = "seat_number")
    private Integer seatNumber;
}
