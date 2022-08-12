package com.car.spring.demo.car.site.dto;

import com.car.spring.demo.car.site.entities.Car;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CarNameRequest {

    private Long id;
    private String name;
    private String model;
    private String description;
    private Long price;

    public CarNameRequest() {
    }

    public CarNameRequest(Long id, String name, String model, String description, Long price) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.description = description;
        this.price = price;
    }

    public CarNameRequest(Car car){
        id=car.getId();
        name=car.getName();
        model=car.getModel();
        description=car.getDescription();
        price=car.getPrice();
    }



}
