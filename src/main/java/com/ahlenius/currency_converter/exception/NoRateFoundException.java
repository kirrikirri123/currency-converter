package com.ahlenius.currency_converter.exception;

public class NoRateFoundException extends RuntimeException {
    public NoRateFoundException(String message) {
        super(message);
    }
}
