package com.example.graphql.controller;

import com.example.graphql.dto.VehicleDto;
import com.example.graphql.model.Vehicle;
import com.example.graphql.repository.VehicleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class VehicleController {

    private final VehicleRepository vehicleRepository;

    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @PostConstruct
    public void init(){
        Vehicle vehicle=new Vehicle();
        vehicle.setBrandName("BWM");
        vehicle.setLaunchDate(new Date());
        vehicle.setModelCode("2020");
        vehicle.setType("SW");
        vehicleRepository.save(vehicle);
    }

    @SchemaMapping(typeName = "Query", value="getVehicles")
    public List<Vehicle> getVehicles(@Argument String type) {
        return vehicleRepository.getByTypeLike(type);
    }

    @QueryMapping
    public Optional<Vehicle> getById(@Argument Long id) {
        return vehicleRepository.findById(id);
    }

    @MutationMapping
    public Vehicle createVehicle(@Argument VehicleDto vehicleDto) {
        return vehicleRepository.save(dtoToEntity(vehicleDto));
    }

    private Vehicle dtoToEntity(VehicleDto vehicleDto){
        Vehicle vehicle=new Vehicle();
        vehicle.setBrandName(vehicleDto.getBrandName());
        vehicle.setLaunchDate(new Date());
        vehicle.setModelCode(vehicleDto.getModelCode());
        vehicle.setType(vehicleDto.getType());
        return vehicle;
    }
}
