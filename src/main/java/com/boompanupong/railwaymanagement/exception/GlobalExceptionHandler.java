package com.boompanupong.railwaymanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.SocketTimeoutException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //GENERAL
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneralException(Exception ex) {
        ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                "An unexpected error occurred.",
                ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //404
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(NotFoundException ex) {
        ApiError error = new ApiError(HttpStatus.NOT_FOUND,
                "Notfound Error.",
                ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //500
    @ExceptionHandler(ServiceUnavailableException.class)
    public ResponseEntity<ApiError> handleServiceUnavailable(ServiceUnavailableException ex) {
        ApiError error = new ApiError(HttpStatus.SERVICE_UNAVAILABLE,
                "Service is temporarily unavailable. Please try again later.",
                ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.SERVICE_UNAVAILABLE);
    }

    //503
    @ExceptionHandler({TimeoutException.class, SocketTimeoutException.class})
    public ResponseEntity<ApiError> handleTimeout(Exception ex) {
        ApiError error = new ApiError(HttpStatus.GATEWAY_TIMEOUT,
                "The request timed out. Please try again later.",
                ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.GATEWAY_TIMEOUT);
    }
}