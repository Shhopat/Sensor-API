package com.example.Spring.REST.API.repositories;

import com.example.Spring.REST.API.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepositories extends JpaRepository<Sensor,Integer> {
}
