package com.example.bookingrooms.dto.converter;

import com.example.bookingrooms.dto.BuildingDto;
import com.example.bookingrooms.model.Building;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BuildingConverter {
    private final ModelMapper modelMapper;

    public BuildingConverter() {
        this.modelMapper = new ModelMapper();
    }
    public BuildingDto convertToDto(Building building) {
        return modelMapper.map(building, BuildingDto.class);
    }
}
