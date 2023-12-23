package com.example.bookingrooms.dto.converter;

import com.example.bookingrooms.dto.ApartmentDto;
import com.example.bookingrooms.model.Apartment;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ApartmentConverter {
    private final ModelMapper modelMapper;

    public ApartmentConverter() {
        this.modelMapper = new ModelMapper();
    }

    public ApartmentDto convertToDto(Apartment apartment) {
        return modelMapper.map(apartment, ApartmentDto.class);
    }
}
