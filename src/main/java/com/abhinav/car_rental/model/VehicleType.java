package com.abhinav.car_rental.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "vehicle_type")
public class VehicleType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "people_capacity")
    private Integer peopleCapacity;

    @Column(name = "luggage_capacity")
    private Integer luggageCapacity;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "fuel_type", length = 50)
    private String fuelType;

    @Column(name = "transmission_type", length = 50)
    private String transmissionType;

    @Column(name = "average_mileage")
    private Float averageMileage;

    @Column(name = "year_of_manufacture")
    private Integer yearOfManufacture;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "last_service_date")
    private Date lastServiceDate;

    @Column(name = "created_date", nullable = true, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdDate;

    @Column(name = "updated_date", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date updatedDate;

    @Column(name = "created_by", length = 100)
    private String createdBy;

    @Column(name = "updated_by", length = 100)
    private String updatedBy;

}

