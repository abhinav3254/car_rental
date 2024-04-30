package com.abhinav.car_rental.controller;


import com.abhinav.car_rental.dto.AuthResponseDTO;
import com.abhinav.car_rental.dto.LogInDTO;
import com.abhinav.car_rental.dto.ProfileDTO;
import com.abhinav.car_rental.dto.SignUpDTO;
import com.abhinav.car_rental.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    private AuthResponseDTO register(@ModelAttribute SignUpDTO sign) {
        return authService.register(sign);
    }

    @PostMapping("/login")
    private AuthResponseDTO login(@RequestBody LogInDTO logInDTO) {
        return authService.login(logInDTO);
    }

    @GetMapping("/profile")
    private ProfileDTO getProfile() {
        return authService.getProfile();
    }
}
