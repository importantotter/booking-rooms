package com.example.bookingrooms.dto;

import com.example.bookingrooms.model.Apartment;
import com.example.bookingrooms.model.Role;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Role role;
    private List<ApartmentDto> apartment;
}
