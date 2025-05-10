package com.example.Spring.REST.API.mapper;

import com.example.Spring.REST.API.DTO.SkyDTO;
import com.example.Spring.REST.API.model.Sky;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkyMapper {
    public Sky toEntity(SkyDTO skyDTO);

    public SkyDTO toDTO(Sky sky);
}
