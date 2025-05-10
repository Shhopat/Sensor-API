package com.example.Spring.REST.API.util;

public class SkyNotValidException extends  RuntimeException{
    public SkyNotValidException(String message) {
        super(message);
    }
}
