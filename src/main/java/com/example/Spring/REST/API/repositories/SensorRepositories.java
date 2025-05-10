package com.example.Spring.REST.API.repositories;

import com.example.Spring.REST.API.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorRepositories extends JpaRepository<Sensor, Integer> {
    boolean existsByName(String name);
    Optional<Sensor> findByName(String string);
}
