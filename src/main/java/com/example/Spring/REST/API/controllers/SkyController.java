package com.example.Spring.REST.API.controllers;

import com.example.Spring.REST.API.DTO.SkyDTO;
import com.example.Spring.REST.API.mapper.SensorMapper;
import com.example.Spring.REST.API.mapper.SkyMapper;
import com.example.Spring.REST.API.model.Sensor;
import com.example.Spring.REST.API.model.Sky;

import com.example.Spring.REST.API.service.SensorService;
import com.example.Spring.REST.API.service.SkyService;
import com.example.Spring.REST.API.util.NoSuchSensorException;
import com.example.Spring.REST.API.util.SkyNotValidException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sky")
public class SkyController {
    private final SkyService skyService;

    private final SensorService sensorService;
    private final SkyMapper skyMapper;


    @Autowired
    public SkyController(SkyService skyService, SensorService sensorService, SkyMapper skyMapper) {
        this.skyService = skyService;
        this.sensorService = sensorService;
        this.skyMapper = skyMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid SkyDTO skyDTO,
                                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder stringBuilder = new StringBuilder();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError error : fieldErrors) {
                stringBuilder.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append("; ");
            }
            throw new SkyNotValidException(stringBuilder.toString());
        }
        Sky sky = skyMapper.toEntity(skyDTO);
        Sensor sensor = sensorService.findByName(skyDTO.getSensorDTO().getName());
        sky.setSensor(sensor);
        sky.setDate(LocalDateTime.now());
        skyService.save(sky);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SkyDTO>> getAllSky() {
        List<SkyDTO> skyDTOList = skyMapper.toDTOList(skyService.findAll());
        return new ResponseEntity<>(skyDTOList, HttpStatus.OK);

    }

    @GetMapping("/rain")
    public ResponseEntity<List<SkyDTO>> getRainDay() {
        List<SkyDTO> skyDTOList = skyMapper.toDTOList(skyService.findAll()
                .stream().filter(Sky::isRaning).toList());

        return new ResponseEntity<>(skyDTOList, HttpStatus.OK);
    }
}
