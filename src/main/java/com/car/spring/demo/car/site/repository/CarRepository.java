package com.car.spring.demo.car.site.repository;

import com.car.spring.demo.car.site.dto.CarDto;
import com.car.spring.demo.car.site.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    List<Car> findByModel(String model);
    List<Car> findByModelAndName(String model, String name);
    List<Car> findByPrice(Long price);

}
