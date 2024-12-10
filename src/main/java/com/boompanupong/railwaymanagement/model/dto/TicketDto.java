package com.boompanupong.railwaymanagement.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketDto {
    private Long id;

    private Long passengerId;

    private Long trainId;

    private LocalDateTime bookingDate;

    private Double price;

    private Integer seatNumber;
}
