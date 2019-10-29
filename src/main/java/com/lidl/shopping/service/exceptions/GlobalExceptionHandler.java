package com.lidl.shopping.service.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrderNotFoundException.class)
    public ErrorInfo orderNotFoundExceptionHandler(
            HttpServletRequest request,
            HttpServletResponse response,
            OrderNotFoundException exception) {
        
        response.setHeader("customHeader", "hello");
        return new ErrorInfo(HttpStatus.NOT_FOUND.value(), 
                request.getRequestURL().toString(), 
                exception.getMessage());
    }
}
