package com.example.bookingrooms.controller;

import com.example.bookingrooms.dto.BuildingDto;
import com.example.bookingrooms.model.Building;
import com.example.bookingrooms.service.BuildingService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/building")
public class BuildingController {

    private BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @PostMapping("/")
    @PreAuthorize("hasAnyAuthority('create')")
    @ResponseStatus(HttpStatus.CREATED)
    public Building createBuilding(@RequestBody Building building) {
        return buildingService.createBuilding(building);
    }

    @GetMapping("/")
    @PreAuthorize("hasAnyAuthority('read')")
    @ResponseStatus(HttpStatus.OK)
    public List<Building> getAllBuilding() {
        return buildingService.getAllBuildings();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('read')")
    @ResponseStatus(HttpStatus.OK)
    public BuildingDto getBuildingById(@PathVariable("id") long buildingId) {
        return buildingService.getBuildingId(buildingId);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('update')")
    @ResponseStatus(HttpStatus.OK)
    public Building updateBuilding(@PathVariable("id") long buildingId, @RequestBody Building building) {
        return buildingService.updateBuilding(buildingId, building);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('delete')")
    @ResponseStatus(HttpStatus.OK)
    public String deleteBuilding(@PathVariable("id") long buildingId) {
        buildingService.deleteBuilding(buildingId);
        return("Building deleted successfully");
    }
}
