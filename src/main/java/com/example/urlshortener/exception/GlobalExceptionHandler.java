package com.example.urlshortener.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.MalformedURLException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MalformedURLException.class)
    public ProblemDetail handleEmployeeNotFoundException(MalformedURLException e) {
        ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        return detail;
    }
}
