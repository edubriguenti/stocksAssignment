package com.payconiq.stock.configuration;

import com.payconiq.stock.exception.StockNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

    @RequestMapping(produces = "application/json")
    @ExceptionHandler(StockNotFoundException.class)
    public ResponseEntity<ApiError> handleException(StockNotFoundException ex) {
        return new ResponseEntity<ApiError>(new ApiError(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(produces = "application/json")
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleException(IllegalArgumentException ex) {
        return new ResponseEntity<ApiError>(new ApiError(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

}