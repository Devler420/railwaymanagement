package com.boompanupong.railwaymanagement.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiError {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private String details;

    public ApiError(HttpStatus status, String message, String details) {
        this.timestamp = LocalDateTime.now();
        this.status = status.value();
        this.message = message;
        this.details = details;
    }
}
