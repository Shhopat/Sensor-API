package com.example.Spring.REST.API.DTO;
import com.example.Spring.REST.API.DTO.SkyDTO;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

public class SensorDTO {

    public SensorDTO() {
    }

    public SensorDTO(String name) {
        this.name = name;
    }

    @Column(name = "name", nullable = false, length = 30, unique = true)
    @NotEmpty(message = "not should be empty")
    @Size(min = 3, max = 30, message = "length should be between 3 and 30 character")
    private String name;

    @OneToMany(mappedBy = "sensorDTO", fetch = FetchType.EAGER)
    private List<SkyDTO> skyDTOList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SkyDTO> getSkyList() {
        return skyDTOList;
    }

    public void setSkyList(List<SkyDTO> skyDTODTOList) {
        this.skyDTOList = skyDTODTOList;
    }
}
