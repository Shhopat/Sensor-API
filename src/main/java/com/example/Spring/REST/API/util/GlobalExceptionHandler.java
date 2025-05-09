package com.example.Spring.REST.API.util;

import com.example.Spring.REST.API.DTO.SensorExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<SensorExceptionDTO> exceptionNotCreated(SensorNotCreatedException e) {
        SensorExceptionDTO sensorExceptionDTO = new SensorExceptionDTO(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(sensorExceptionDTO, HttpStatus.BAD_REQUEST);

    }
}
