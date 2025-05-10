package com.example.Spring.REST.API.service;

import com.example.Spring.REST.API.DTO.SkyDTO;
import com.example.Spring.REST.API.model.Sky;
import com.example.Spring.REST.API.repositories.SkyRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SkyService {
    private final SkyRepositories skyRepositories;

    public SkyService(SkyRepositories skyRepositories) {
        this.skyRepositories = skyRepositories;
    }


    @Transactional
    public void save(Sky sky) {
        skyRepositories.save(sky);
    }
}
