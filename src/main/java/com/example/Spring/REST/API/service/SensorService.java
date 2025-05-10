package com.example.Spring.REST.API.service;

import com.example.Spring.REST.API.model.Sensor;
import com.example.Spring.REST.API.repositories.SensorRepositories;
import com.example.Spring.REST.API.util.NoSuchSensorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
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

    public boolean existsByName(String name) {
        return sensorRepositories.existsByName(name);
    }

    public Sensor findById(int id) {
        return sensorRepositories.findById(id).orElseThrow(NoSuchSensorException::new);
    }

    public Sensor findByName(String name) {
        return sensorRepositories.findByName(name).orElseThrow(NoSuchSensorException::new);
    }


}
