package com.abhinav.car_rental.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@AllArgsConstructor @NoArgsConstructor
@Data
public class ExceptionMessageBuilder {
    private String message;
    private HttpStatus httpStatus;
}
