package com.boompanupong.railwaymanagement.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TrainDto {
    private Long id;

    private String trainNumber;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;

    private Long originStationId;

    private Long destinationStationId;

    private Integer seatCapacity;

    private Double ticketPrice;
}