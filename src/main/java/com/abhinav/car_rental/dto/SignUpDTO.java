package com.abhinav.car_rental.dto;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class SignUpDTO {
    private String name;
    private String gender;
    private String email;
    private String phone;
    private String password;
    private String occupation;
    private String address;
    private MultipartFile profilePhoto;
}
