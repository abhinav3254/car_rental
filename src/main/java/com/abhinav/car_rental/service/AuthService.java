package com.abhinav.car_rental.service;


import com.abhinav.car_rental.dto.AuthResponseDTO;
import com.abhinav.car_rental.dto.LogInDTO;
import com.abhinav.car_rental.dto.SignUpDTO;
import com.abhinav.car_rental.exception.CustomException;
import com.abhinav.car_rental.jwt.JwtUtils;
import com.abhinav.car_rental.model.User;
import com.abhinav.car_rental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtils jwtUtils;

    public AuthResponseDTO register(SignUpDTO sign) {
        User user = setUpUser(sign);
        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
        if (userOptional.isPresent()) throw new CustomException("Email Already In User", HttpStatus.BAD_REQUEST);
        User savedUser = userRepository.save(user);
        return new AuthResponseDTO("User Registered with id "+savedUser.getId());
    }

    private User setUpUser(SignUpDTO sign) {
        User user = new User();
        user.setName(sign.getName());
        user.setGender(sign.getGender());
        if (sign.getEmail().isEmpty()) throw new CustomException("Email can't be Empty",HttpStatus.BAD_REQUEST);
        user.setEmail(sign.getEmail());
        user.setPhone(sign.getPhone());
        if (sign.getPassword().isEmpty()) throw new CustomException("Password can't be Empty",HttpStatus.BAD_REQUEST);
        user.setPassword(sign.getPassword());
        user.setOccupation(sign.getOccupation());
        user.setAddress(sign.getAddress());
        user.setStatus(true);
        user.setRole("USER");
        if (!sign.getProfilePhoto().isEmpty()) {
            try {
                byte[] bytes = sign.getProfilePhoto().getBytes();
                user.setProfilePhoto(bytes);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        user.setCreatedDate(new Date(System.currentTimeMillis()));
        user.setCreatedBy("SYSTEM");
        return user;
    }

    public AuthResponseDTO login(LogInDTO logInDTO) {
        Optional<User> userOptional = userRepository.findByEmail(logInDTO.getEmail());
        if (userOptional.isEmpty()) throw new CustomException("User not found",HttpStatus.NOT_FOUND);
        User user = userOptional.get();
        if (!logInDTO.getPassword().equals(user.getPassword())) throw new CustomException("Wrong Password",HttpStatus.BAD_REQUEST);
        String token = jwtUtils.generateToken(user.getEmail(),user.getId(),user.getRole());
        return new AuthResponseDTO(token);
    }
}
