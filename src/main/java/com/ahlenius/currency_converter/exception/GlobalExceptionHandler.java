package com.ahlenius.currency_converter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(NoRateFoundException.class)
    public ResponseEntity<?> NotFound(NoRateFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                        "timestamp", LocalDateTime.now().toString(),
                        "status", (HttpStatus.NOT_FOUND.value()),
                        "error", "No matching rate found on currency request",
                        "message", e.getMessage()
                ));
    }

    @ExceptionHandler(FrankfurterApiException.class)
    public ResponseEntity<?> converterDown(FrankfurterApiException e) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(
                Map.of(
                        "timestamp", LocalDateTime.now().toString(),
                        "status", (HttpStatus.SERVICE_UNAVAILABLE.value()),
                        "error", "Converter service unavailable",
                        "message", e.getMessage()
                ));
    }
}
