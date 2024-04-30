package com.abhinav.car_rental.dto;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class VehicleCompanyDTO {

    private String name;

    private String address;

    private String contactPhone;

    private String website;

    private MultipartFile logo;

}
