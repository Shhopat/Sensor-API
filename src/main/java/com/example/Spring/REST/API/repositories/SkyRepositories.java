package com.example.Spring.REST.API.repositories;

import com.example.Spring.REST.API.model.Sky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkyRepositories extends JpaRepository<Sky, Integer> {
}
