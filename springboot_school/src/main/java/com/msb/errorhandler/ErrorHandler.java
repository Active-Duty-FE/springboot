package com.msb.errorhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(value= {java.lang.ArithmeticException.class})
    public String ArithmeticExceptionHandler() {
        System.out.println("ArithmeticExceptionHandler");
        return "error";
    }
}
