package com.abhinav.car_rental.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor @NoArgsConstructor
@Data
public class CustomException extends RuntimeException {
    private String message;
    private HttpStatus httpStatus;
}
