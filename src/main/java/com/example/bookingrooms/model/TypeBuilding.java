package com.example.bookingrooms.model;

public enum TypeBuilding {

    HOTEL("Hotel"),
    PRIVATE_HOUSE("Private House"),
    APARTMENT("Apartment");
    private final String typeBuilding;
    TypeBuilding(String typeBuilding) {
        this.typeBuilding = typeBuilding;
    }

    public String getTypeBuilding() {
        return typeBuilding;
    }
}
