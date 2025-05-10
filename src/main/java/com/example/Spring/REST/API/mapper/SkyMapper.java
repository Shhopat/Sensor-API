package com.example.Spring.REST.API.mapper;

import com.example.Spring.REST.API.DTO.SkyDTO;
import com.example.Spring.REST.API.model.Sky;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = SensorMapper.class)
public interface SkyMapper {
    Sky toEntity(SkyDTO skyDTO);

    @Mapping(source = "sensor", target = "sensorDTO")
    SkyDTO toDTO(Sky sky);

    List<Sky> toEntityList(List<SkyDTO> skyDTOList);

    List<SkyDTO> toDTOList(List<Sky> skyList);

}
