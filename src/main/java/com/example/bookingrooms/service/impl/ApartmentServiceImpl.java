package com.example.bookingrooms.service.impl;

import com.example.bookingrooms.dto.ApartmentDto;
import com.example.bookingrooms.dto.converter.ApartmentConverter;
import com.example.bookingrooms.exception.ApartmentNotFoundException;
import com.example.bookingrooms.model.Apartment;
import com.example.bookingrooms.repositories.ApartmentRepository;
import com.example.bookingrooms.service.ApartmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    private final ApartmentRepository apartmentRepository;
    private final ApartmentConverter apartmentConverter;

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, ApartmentConverter apartmentConverter) {
        this.apartmentRepository = apartmentRepository;
        this.apartmentConverter = apartmentConverter;
    }

    @Override
    public Apartment createApartment(Apartment apartment) {
        return apartmentRepository.save(apartment);
    }

    @Override
    public ApartmentDto getApartmentId(long id) {
        Apartment apartment = apartmentRepository.findById(id).get();
        return apartmentConverter.convertToDto(apartment);
    }

    @Override
    public Apartment updateApartment(long id, Apartment newApartment) {
        Apartment apartment = apartmentRepository.findById(id).orElseThrow(
                () -> new ApartmentNotFoundException(String.format("Customer with id '%d' not found", id))
        );

        handleApartmentUpdate(apartment, newApartment);
        apartmentRepository.save(apartment);
        return apartment;
    }

    @Override
    public void deleteApartment(long id) {
        Apartment apartment = apartmentRepository.findById(id).orElseThrow(
                () -> new ApartmentNotFoundException(String.format("Customer with id '%d' not found", id))
        );

        apartmentRepository.delete(apartment);
    }

    @Override
    public List<Apartment> getAllApartments() {
        Page<Apartment> apartments = apartmentRepository.findAll(PageRequest.of(0, 10));
        return apartments.toList();
    }

    private void handleApartmentUpdate(Apartment apartment, Apartment newApartment) {
        apartment.setBuilding(newApartment.getBuilding());
        apartment.setCustomer(newApartment.getCustomer());
        apartment.setDescription(newApartment.getDescription());
        apartment.setFloor(newApartment.getFloor());
    }
}
