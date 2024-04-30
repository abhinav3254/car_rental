package com.abhinav.car_rental.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
    Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException e) {
        log.error("something went wrong {}",e.getMessage());
        return ResponseEntity.status(e.getHttpStatus()).body(new ExceptionMessageBuilder(e.getMessage(),e.getHttpStatus()));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleNullPointerException(NullPointerException e) {
        log.error("something went wrong {}",e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionMessageBuilder(e.getMessage(),HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentExceptionException(NullPointerException e) {
        log.error("something went wrong {}",e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionMessageBuilder(e.getMessage(),HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        log.error("something went wrong {}",e.getMessage());
        return ResponseEntity.status(500).body(new ExceptionMessageBuilder(e.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
