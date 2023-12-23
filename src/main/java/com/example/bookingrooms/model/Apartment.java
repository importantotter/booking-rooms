package com.example.bookingrooms.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "apartment")
@Data
@NoArgsConstructor
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String floor;
    @NotNull
    private String squareMeters;
    @Column(columnDefinition = "text")
    @NotNull
    private String description;
    @ManyToOne
    @JsonBackReference
    private Building building;
    @ManyToOne()
    @JsonBackReference
    private Customer customer;

}
