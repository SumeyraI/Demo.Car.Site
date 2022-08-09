package com.car.spring.demo.car.site.services.impl;

import com.car.spring.demo.car.site.dto.CarDto;
import com.car.spring.demo.car.site.entities.Car;

import java.util.List;

public interface ICarService {
    List<CarDto> getAll();

    CarDto getById(Long id);

    CarDto createCar(CarDto carDto);

    void deleteCar(Long id);

    CarDto updateCar(Long id, CarDto carDto);

    List<Car> getByModel(String model);

    List<Car> getByModelAndName(String model, String name);

    List<Car> getByPrice(Long price);
}
