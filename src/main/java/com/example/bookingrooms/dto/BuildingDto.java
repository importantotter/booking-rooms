package com.example.bookingrooms.dto;

import com.example.bookingrooms.model.Apartment;
import com.example.bookingrooms.model.TypeBuilding;
import lombok.Data;

import java.util.List;

@Data
public class BuildingDto {
    private Long id;
    private String addressBuilding;
    private TypeBuilding typeBuilding;
    private String floorBuilding;
    private List<ApartmentDto> apartment;
}
