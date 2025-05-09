package com.example.Spring.REST.API.controllers;

import com.example.Spring.REST.API.DTO.SensorDTO;
import com.example.Spring.REST.API.mapper.SensorMapper;
import com.example.Spring.REST.API.service.SensorService;
import com.example.Spring.REST.API.util.SensorNotCreatedException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorController {
    private final SensorService sensorService;
    private final SensorMapper sensorMapper;

    @Autowired
    public SensorController(SensorService service, SensorMapper sensorMapper) {
        this.sensorService = service;
        this.sensorMapper = sensorMapper;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid SensorDTO sensorDTO,
                                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder stringBuilder = new StringBuilder();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError error : fieldErrors) {
                stringBuilder.append(error.getField()).append(" - ")
                        .append(error.getDefaultMessage())
                        .append(" ;");
            }
            throw new SensorNotCreatedException(stringBuilder.toString());
        }
        sensorService.save(sensorMapper.toEntity(sensorDTO));
        return ResponseEntity.ok(HttpStatus.OK); //200

    }
}
