package com.abhinav.car_rental.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Data
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private VehicleType type;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private VehicleCompany company;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "vehicle_img")
    private byte[] vehicleImage;

    @Column(name = "available")
    private Boolean available;

    @Column(name = "color", length = 50)
    private String color;

    @Column(name = "registration_number", unique = true, length = 20)
    private String registrationNumber;

    @Column(name = "year_of_manufacture")
    private Integer yearOfManufacture;

    @Column(name = "mileage")
    private Integer mileage;

    @Column(name = "last_service_date")
    private Date lastServiceDate;

    @Column(name = "insurance_expiry_date")
    private Date insuranceExpiryDate;

    @Column(name = "late_fine", nullable = false, precision = 10, scale = 2)
    private BigDecimal lateFine;

    @Column(name = "created_date", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdDate;

    @Column(name = "updated_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date updatedDate;

    @Column(name = "created_by", length = 100)
    private String createdBy;

    @Column(name = "updated_by", length = 100)
    private String updatedBy;

}
