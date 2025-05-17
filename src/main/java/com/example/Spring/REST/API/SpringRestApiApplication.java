package com.example.Spring.REST.API;

import com.example.Spring.REST.API.DTO.SensorDTO;
import com.example.Spring.REST.API.DTO.SkyDTO;
import com.example.Spring.REST.API.client.SensorClient;
import com.example.Spring.REST.API.client.SkyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SpringRestApiApplication implements CommandLineRunner {

    private final SensorClient sensorClient;
    private final SkyClient skyClient;

    @Autowired
    public SpringRestApiApplication(SensorClient sensorClient, SkyClient skyClient) {
        this.sensorClient = sensorClient;
        this.skyClient = skyClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringRestApiApplication.class, args);
    }

    @Override
    public void run(String... args) {
        SensorDTO sensor = new SensorDTO("Sensor-4");
        //спецом не залегали сенсор, чтобы увидеть, как отработает ошибка

        SkyDTO skyDTO = new SkyDTO(14.1, true, LocalDateTime.now(), sensor);
        try {
            skyClient.addSkyMeasurement(skyDTO);
        } catch (RuntimeException runtimeException) {
            System.out.println("Не смог добавить показания: " + runtimeException.getMessage());
        }


    }

}
