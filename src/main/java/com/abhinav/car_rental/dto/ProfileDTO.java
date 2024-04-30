package com.abhinav.car_rental.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
public class ProfileDTO {
    private Integer id;
    private String name;
    private String gender;
    private String email;
    private String phone;
    private String occupation;
    private String address;
    private String profilePhoto;
}
