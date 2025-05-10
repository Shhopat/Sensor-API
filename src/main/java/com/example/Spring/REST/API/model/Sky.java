package com.example.Spring.REST.API.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "sky")
public class Sky {
    public Sky() {
    }

    public Sky(int id, double value, boolean raning, LocalDateTime date, Sensor sensor) {
        this.id = id;
        this.value = value;
        this.raning = raning;
        this.date = date;
        this.sensor = sensor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value", nullable = false)
    @NotNull(message = " value not should be empty")
    @Max(value = 100, message = "value should be between -100 and 100")
    @Min(value = -100, message = "value should be between -100 and 100")
    private double value;

    @Column(name = "raning", nullable = false)
    private boolean raning;

    @Column(name = "date", nullable = true)
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sensor_id", referencedColumnName = "id", nullable = false)
    private Sensor sensor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isRaning() {
        return raning;
    }

    public void setRaning(boolean raning) {
        this.raning = raning;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public void setDate(LocalDateTime localDateTime) {
        date = localDateTime;
    }
}
