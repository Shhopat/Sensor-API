package com.example.Spring.REST.API.mapper;

import com.example.Spring.REST.API.DTO.SensorDTO;
import com.example.Spring.REST.API.model.Sensor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SensorMapper {
    public Sensor toEntity(SensorDTO sensorDTO);

    public SensorDTO toDTO(Sensor sensor);
}
