package com.example.Spring.REST.API.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "sensor")
public class Sensor {
    public Sensor() {
    }

    public Sensor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, length = 30, unique = true)
    @NotEmpty(message = "not should be empty")
    @Size(min = 3, max = 30, message = "length should be between 3 and 30 character")
    private String name;

    @OneToMany(mappedBy = "sensor", fetch = FetchType.EAGER)
    private List<Sky> skyList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sky> getSkyList() {
        return skyList;
    }

    public void setSkyList(List<Sky> skyList) {
        this.skyList = skyList;
    }
}
