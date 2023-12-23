package com.example.bookingrooms.service;

import com.example.bookingrooms.dto.BuildingDto;
import com.example.bookingrooms.model.Building;

import java.util.List;

public interface BuildingService {

    Building createBuilding(Building building);
    BuildingDto getBuildingId(long id);
    Building updateBuilding(long id, Building building);
    void deleteBuilding(long id);
    List<Building> getAllBuildings();
}
