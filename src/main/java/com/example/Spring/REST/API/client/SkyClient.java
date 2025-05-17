package com.example.Spring.REST.API.client;

import com.example.Spring.REST.API.DTO.ExceptionDTO;
import com.example.Spring.REST.API.DTO.SkyDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class SkyClient {
    private final WebClient webClient;

    public SkyClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public void addSkyMeasurement(SkyDTO sky) {
        webClient.post()
                .uri("/sky/add")
                .bodyValue(sky)
                .retrieve()
                .onStatus(status -> status.is4xxClientError(), response ->
                        response.bodyToMono(ExceptionDTO.class)
                                .flatMap(error -> Mono.error(new RuntimeException("Ошибка: " + error.getMessage())))
                )
                .onStatus(status -> status.is5xxServerError(), response ->
                        response.bodyToMono(String.class)
                                .flatMap(error -> Mono.error(new RuntimeException("Серверная ошибка: " + error)))
                )
                .toBodilessEntity()
                .block();
    }


    public List<SkyDTO> getAllSkyMeasurements() {
        return webClient.get()
                .uri("/sky/all")
                .retrieve()
                .onStatus(status -> status.is4xxClientError(), response ->
                        response.bodyToMono(String.class)
                                .flatMap(error -> Mono.error(new RuntimeException("Ошибка на стороне клиента: " + error))))
                .onStatus(status -> status.is5xxServerError(), response ->
                        response.bodyToMono(String.class).flatMap(error ->
                                Mono.error(new RuntimeException("Ошибка на стороне сервера: " + error))))
                .bodyToFlux(SkyDTO.class)
                .collectList()
                .block();

    }
}
