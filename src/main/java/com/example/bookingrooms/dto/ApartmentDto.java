package com.example.bookingrooms.dto;

import com.example.bookingrooms.model.Building;
import com.example.bookingrooms.model.Customer;
import lombok.Data;

@Data
public class ApartmentDto {
    private Long id;
    private String floor;
    private String squareMeters;
    private String description;
    private Building building;
    private CustomerDto customerDto;
}
