package com.example.Spring.REST.API.service;

import com.example.Spring.REST.API.model.Sensor;
import com.example.Spring.REST.API.repositories.SensorRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SensorService {

    private final SensorRepositories sensorRepositories;

    @Autowired
    public SensorService(SensorRepositories sensorRepositories) {
        this.sensorRepositories = sensorRepositories;
    }

    @Transactional
    public void save(Sensor sensor) {
        sensorRepositories.save(sensor);
    }
}
