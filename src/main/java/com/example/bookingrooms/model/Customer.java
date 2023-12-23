package com.example.bookingrooms.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    @NotNull
    private String firstName;
    @Column(name = "last_name")
    @NotNull
    private String lastName;
    @Email(message = "Email address has invalid format: ${validatedValue}",
            regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
    @Column(name = "email", length = 255, unique = true)
    @NotNull
    private String email;
    @Column(name = "phone_number", unique = true)
    @Size(min = 10, max = 25, message = "The phone number: ${validatedValue} must be at least {min}" +
            " {max} characters long")
    @NotNull
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    @NotNull
    private Role role;
    @Column(name = "password", unique = true)
    @NotNull
    private String password;
    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private List<Apartment> apartment;

}