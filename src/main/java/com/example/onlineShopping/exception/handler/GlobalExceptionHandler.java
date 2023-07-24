package com.example.onlineShopping.exception.handler;

import com.example.onlineShopping.exception.CustomerNotFound;
import com.example.onlineShopping.response.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> exception(MethodArgumentNotValidException exception) {
        GenericResponse genericResponse = new GenericResponse(false, "Validation Failed", "Method Argument Not Valid Exception", HttpStatus.BAD_REQUEST.value());
        log.error("handling MethodArgumentNotValidException...");
        return new ResponseEntity<>(genericResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerNotFound.class)
    public ResponseEntity<Object> exception(CustomerNotFound exception){
        GenericResponse genericResponse = new GenericResponse(false, "Customer not found", null, HttpStatus.BAD_REQUEST.value());
        log.error("handling CustomerNotFoundException...");
        return new ResponseEntity<>(genericResponse, HttpStatus.BAD_REQUEST);
    }
}
