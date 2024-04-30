package com.abhinav.car_rental.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Data
public class VehicleDTO {


    private String name;

    private Integer type;

    private Integer company;

    private BigDecimal price;

    private MultipartFile vehicleImage;

    private Boolean available;

    private String color;

    private String registrationNumber;

    private Integer yearOfManufacture;

    private Integer mileage;

    private String lastServiceDate;

    private String insuranceExpiryDate;

    private BigDecimal lateFine;

}
