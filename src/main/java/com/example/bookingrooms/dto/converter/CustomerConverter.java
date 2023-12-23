package com.example.bookingrooms.dto.converter;

import com.example.bookingrooms.dto.CustomerDto;
import com.example.bookingrooms.model.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {
    private final ModelMapper modelMapper;

    public CustomerConverter() {
        this.modelMapper = new ModelMapper();
    }
    public CustomerDto convertToDto(Customer customer) {
        return modelMapper.map(customer, CustomerDto.class);
    }
}
