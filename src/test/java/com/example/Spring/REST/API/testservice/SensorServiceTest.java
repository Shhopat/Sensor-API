package com.example.Spring.REST.API.testservice;

import com.example.Spring.REST.API.model.Sensor;
import com.example.Spring.REST.API.repositories.SensorRepositories;
import com.example.Spring.REST.API.service.SensorService;
import com.example.Spring.REST.API.util.NoSuchSensorException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.AbstractSet;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class SensorServiceTest {

    @Mock
    private SensorRepositories sensorRepositories;

    @InjectMocks
    private SensorService service;

    private Sensor sensor;

    private Optional<Sensor> optionalSensor;

    @BeforeEach
    void init() {
        sensor = new Sensor(3, "Sensor-2");
    }

    @Test
    void shouldBeSave() {
        service.save(sensor);
        Mockito.verify(sensorRepositories).save(sensor);
    }

    @Test
    void shouldBeReturnTrueIfSensorExistsByUserName() {
        Mockito.when(sensorRepositories.existsByName(sensor.getName())).thenReturn(true);
        Assertions.assertTrue(service.existsByName(sensor.getName()));

        Mockito.verify(sensorRepositories).existsByName(sensor.getName());
    }

    @Test
    void shouldBeGetSensorById() {
        Mockito.when(sensorRepositories.findById(sensor.getId())).thenReturn(Optional.of(sensor));
        Sensor sensor1 = service.findById(sensor.getId());

        Assertions.assertEquals(sensor.getId(), sensor1.getId());
        Assertions.assertEquals(sensor.getName(), sensor1.getName());

        Mockito.verify(sensorRepositories).findById(sensor.getId());


    }

    @Test
    void shouldGetSensorByName() {
        Mockito.when(sensorRepositories.findByName(sensor.getName())).thenReturn(Optional.of(sensor));

        Sensor result = service.findByName(sensor.getName());

        Assertions.assertEquals(sensor.getName(), result.getName());

        Mockito.verify(sensorRepositories).findByName(sensor.getName());
    }
}
