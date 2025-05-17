package com.example.Spring.REST.API.client;

import com.example.Spring.REST.API.DTO.ExceptionDTO;
import com.example.Spring.REST.API.DTO.SensorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class SensorClient {
    private final WebClient webClient;

    @Autowired
    public SensorClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public void registrationSensor(SensorDTO sensorDTO) {
        webClient.post().uri("/sensors/registration")
                .bodyValue(sensorDTO)
                .retrieve()
                .onStatus(status -> status.is4xxClientError(),
                        response -> response.bodyToMono(ExceptionDTO.class)
                                .flatMap(error -> Mono.error(new RuntimeException(error.getMessage()))))
                .onStatus(status -> status.is5xxServerError(),
                        response -> response.bodyToMono(String.class)
                                .flatMap(error -> Mono.error(new RuntimeException(error.toString()))))
                .toBodilessEntity()
                .doOnSuccess(v -> System.out.println("Sensor is registered"))
                .block();
    }

}
