package com.car.spring.demo.car.site.exception;

public class CarNotFoundException extends RuntimeException{

    public CarNotFoundException(String message){
        super(message);
    }
}
