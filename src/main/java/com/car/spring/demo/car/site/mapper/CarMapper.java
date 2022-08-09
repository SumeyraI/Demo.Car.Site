package com.car.spring.demo.car.site.mapper;

import com.car.spring.demo.car.site.dto.CarDto;
import com.car.spring.demo.car.site.entities.Car;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarDto CarEntityToDto(Car car);

    Car CarDtoToEntity(CarDto carDto);

    List<CarDto> CarEntityToDtos(List<Car> carList);

    List<Car> CarDtosToEntities (List<CarDto> carDtoList);





}
