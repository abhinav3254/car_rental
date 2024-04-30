package com.abhinav.car_rental.controller;


import com.abhinav.car_rental.dto.ResponseDTO;
import com.abhinav.car_rental.dto.VehicleCompanyDTO;
import com.abhinav.car_rental.dto.VehicleDTO;
import com.abhinav.car_rental.dto.VehicleTypeDTO;
import com.abhinav.car_rental.model.Vehicle;
import com.abhinav.car_rental.model.VehicleCompany;
import com.abhinav.car_rental.model.VehicleType;
import com.abhinav.car_rental.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public Page<Vehicle> getAllVehicle(@RequestParam(required = false,defaultValue = "10") int size,@RequestParam(required = false,defaultValue = "0") int page) {
        return vehicleService.getAllVehicle(size,page);
    }

    @PostMapping("/add")
    public ResponseDTO addVehicle(@ModelAttribute VehicleDTO vehicleDTO) {
        return vehicleService.addVehicle(vehicleDTO);
    }

    @GetMapping("/type")
    public Page<VehicleType> getAllVehicleType(@RequestParam(required = false,defaultValue = "10") int size,@RequestParam(required = false,defaultValue = "0") int page) {
        return vehicleService.getAllVehicleType(size,page);
    }

    @GetMapping("/company")
    public Page<VehicleCompany> getAllCompany(@RequestParam(required = false,defaultValue = "10") int size, @RequestParam(required = false,defaultValue = "0") int page) {
        return vehicleService.getAllCompany(size,page);
    }

    @PostMapping("/type/add")
    public ResponseDTO addVehicleType(@RequestBody VehicleTypeDTO vehicleType) {
        return vehicleService.addVehicleType(vehicleType);
    }

    @PostMapping("/company/add")
    public ResponseDTO addVehicleCompany(@ModelAttribute VehicleCompanyDTO vehicleCompanyDTO) {
        return vehicleService.addVehicleCompany(vehicleCompanyDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseDTO updateVehicle(@PathVariable Integer id, @ModelAttribute VehicleDTO vehicleDTO) {
        return vehicleService.updateVehicle(id, vehicleDTO);
    }

    @PutMapping("/type/update/{id}")
    public ResponseDTO updateVehicleType(@PathVariable Integer id, @RequestBody VehicleTypeDTO vehicleTypeDTO) {
        return vehicleService.updateVehicleType(id, vehicleTypeDTO);
    }

    @PutMapping("/company/update/{id}")
    public ResponseDTO updateVehicleCompany(@PathVariable Integer id, @ModelAttribute VehicleCompanyDTO vehicleCompanyDTO) {
        return vehicleService.updateVehicleCompany(id, vehicleCompanyDTO);
    }

}
