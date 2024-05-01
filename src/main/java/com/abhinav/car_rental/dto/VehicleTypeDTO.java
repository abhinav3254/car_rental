package com.abhinav.car_rental.dto;


import lombok.Data;

@Data
public class VehicleTypeDTO {
    private String name;

    private Integer peopleCapacity;

    private Integer luggageCapacity;

    private String description;

    private String fuelType;

    private String transmissionType;

    private Float averageMileage;

    private String yearOfManufacture;

    private String registrationDate;

    private String lastServiceDate;

}
