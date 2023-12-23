package com.example.bookingrooms.service;

import com.example.bookingrooms.dto.ApartmentDto;
import com.example.bookingrooms.model.Apartment;

import java.util.List;

public interface ApartmentService {

    Apartment createApartment(Apartment apartment);
    ApartmentDto getApartmentId(long id);
    Apartment updateApartment(long id, Apartment apartment);
    void deleteApartment(long id);
    List<Apartment> getAllApartments();

}
