package com.example.Spring.REST.API.util;

public class NoSuchSensorException extends RuntimeException {
    public NoSuchSensorException() {
        super("No such this kind of sensor");
    }
}
