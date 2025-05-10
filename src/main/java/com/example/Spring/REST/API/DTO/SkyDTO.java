package com.example.Spring.REST.API.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class SkyDTO {
    public SkyDTO() {
    }

    public SkyDTO(double value, boolean raning, SensorDTO sensorDTO) {
        this.value = value;
        this.raning = raning;
        this.sensorDTO = sensorDTO;
    }

    @Column(name = "value", nullable = false)
    @NotNull(message = " value not should be empty")
    @Max(value = 100, message = "value should be between -100 and 100")
    @Min(value = -100, message = "value should be between -100 and 100")
    private double value;

    @Column(name = "raning", nullable = false)
    private boolean raning;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sensor_id", referencedColumnName = "id", nullable = false)
    private SensorDTO sensorDTO;

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

    public SensorDTO getSensorDTO() {
        return sensorDTO;
    }

    public void setSensorDTO(SensorDTO sensorDTO) {
        this.sensorDTO = sensorDTO;
    }
}
