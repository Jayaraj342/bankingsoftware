package com.example.demo.exception;

public class InvalidAddressException extends Exception {
    public InvalidAddressException(String message) {
        super(message);
    }
}