package com.example.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler({ArithmeticException.class})
    public String testException(Exception e){

        e.printStackTrace();
        return "error";
    }
}
