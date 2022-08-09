package com.car.spring.demo.car.site.dto;

import lombok.Builder;

@Builder
public class CarModelAndNameResponse {

    private String name;

    private String model;

    public CarModelAndNameResponse() {
    }

    public CarModelAndNameResponse(String name, String model) {
        this.name = name;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
