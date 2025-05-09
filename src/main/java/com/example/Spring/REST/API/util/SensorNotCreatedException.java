package com.example.Spring.REST.API.util;

public class SensorNotCreatedException extends RuntimeException {
    public SensorNotCreatedException(String message) {
        super(message);
    }

    public SensorNotCreatedException() {
        super("Error in fields validation");
    }
}
