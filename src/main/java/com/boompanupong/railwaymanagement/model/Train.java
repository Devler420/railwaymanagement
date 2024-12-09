package com.boompanupong.railwaymanagement.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "train")
@NoArgsConstructor
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "train_number")
    private String trainNumber;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    @ManyToOne
    @JoinColumn(name = "origin_station_id")
    private Station originStation;

    @ManyToOne
    @JoinColumn(name = "destination_station_id")
    private Station destinationStation;

    @Column(name = "seat_capacity")
    private Integer seatCapacity;

    @Column(name = "ticket_price")
    private Double ticketPrice;
}