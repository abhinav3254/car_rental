package com.abhinav.car_rental.jwt;


import com.abhinav.car_rental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    com.abhinav.car_rental.model.User user;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.abhinav.car_rental.model.User> userOptional = userRepository.findByEmail(username);
        if (userOptional.isPresent()) {
            user = userOptional.get();
            return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
        }

        throw new UsernameNotFoundException("user not found by email "+username);

    }



    public com.abhinav.car_rental.model.User getUserDetails() {
        return user;
    }

}