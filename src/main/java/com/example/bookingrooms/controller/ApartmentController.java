package com.example.bookingrooms.controller;

import com.example.bookingrooms.dto.ApartmentDto;
import com.example.bookingrooms.model.Apartment;
import com.example.bookingrooms.service.ApartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apartment")
public class ApartmentController {

    private ApartmentService apartmentService;

    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @PostMapping("/")
    @PreAuthorize("hasAnyAuthority('create')")
    @ResponseStatus(HttpStatus.CREATED)
    public Apartment createApartment(@RequestBody Apartment apartment) {
        return apartmentService.createApartment(apartment);
    }

    @GetMapping("/")
    @PreAuthorize("hasAnyAuthority('read')")
    @ResponseStatus(HttpStatus.OK)
    public List<Apartment> getAllApartment() {
        return apartmentService.getAllApartments();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('read')")
    @ResponseStatus(HttpStatus.OK)
    public ApartmentDto getApartmentById(@PathVariable("id") long apartmentId) {
        return apartmentService.getApartmentId(apartmentId);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('update')")
    @ResponseStatus(HttpStatus.OK)
    public Apartment updateApartment(@PathVariable("id") long apartmentId, @RequestBody Apartment apartment) {
        return apartmentService.updateApartment(apartmentId, apartment);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('delete')")
    @ResponseStatus(HttpStatus.OK)
    public String deleteApartment(@PathVariable("id") long apartmentId) {
        apartmentService.deleteApartment(apartmentId);
        return("Apartment deleted successfully");
    }
}
