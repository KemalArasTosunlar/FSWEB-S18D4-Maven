package com.workintech.s18d1.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<BurgerErrorResponse> habdleException(BurgerException ex){
        log.error("burger exception accured! Excception details:  ", ex);
        BurgerErrorResponse burgerErrorResponse=new BurgerErrorResponse(ex.getMessage());
        return new ResponseEntity<>(burgerErrorResponse, ex.getHttpStatus());
    }

    @ExceptionHandler
    private ResponseEntity<BurgerErrorResponse> habdleException(Exception exception){
        log.error("Exception accured! Excception details:  ", exception);
        BurgerErrorResponse burgerErrorResponse=new BurgerErrorResponse(exception.getMessage());
        return new ResponseEntity<>(burgerErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}