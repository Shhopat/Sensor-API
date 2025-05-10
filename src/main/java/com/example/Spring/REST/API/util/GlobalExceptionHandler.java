package com.example.Spring.REST.API.util;

import com.example.Spring.REST.API.DTO.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionDTO> exceptionNotCreated(SensorNotCreatedException e) {
        ExceptionDTO sensorExceptionDTO = new ExceptionDTO(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(sensorExceptionDTO, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler
    public ResponseEntity<ExceptionDTO> skyExceptionDTOResponseEntity(SkyNotValidException e) {
        ExceptionDTO skyExceptionDTO = new ExceptionDTO(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(skyExceptionDTO, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler
    public ResponseEntity<ExceptionDTO> responseEntity(NoSuchSensorException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }
}
