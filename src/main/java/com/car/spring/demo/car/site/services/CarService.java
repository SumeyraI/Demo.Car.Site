package com.car.spring.demo.car.site.services;

import com.car.spring.demo.car.site.dto.CarDto;
import com.car.spring.demo.car.site.entities.Car;
import com.car.spring.demo.car.site.repository.CarRepository;
import com.car.spring.demo.car.site.services.impl.ICarService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService implements ICarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    public CarService(CarRepository carRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CarDto> getAll() {

        List<Car> carList= carRepository.findAll();
        return carList.stream().map(car -> modelMapper.map(car,CarDto.class)).collect(Collectors.toList());
    }

    @Override
    public CarDto getById(Long id) {

       Car car=carRepository.findById(id).orElseThrow(()->new NullPointerException("Car id not found exception!"));
        return  modelMapper.map(car,CarDto.class);
    }

    @Override
    public CarDto createCar(CarDto carDto) {
        Car car = modelMapper.map(carDto, Car.class);
        car.setCreatedAt(new Date());
        return modelMapper.map(carRepository.save(car), CarDto.class);

    }

    @Override
    public void deleteCar(Long id) {
         carRepository.findById(id).orElseThrow(()->new NullPointerException("The car which you want to delete not found."));
         carRepository.deleteById(id);

    }

    @Override
    public CarDto updateCar(Long id, CarDto carDto) {

        Car car=carRepository.findById(id).orElseThrow(()->new NullPointerException("The car which you want to update not found."));
        car.setName(carDto.getName());
        car.setModel(carDto.getModel());
        car.setUpdatedAt(new Date());
        car.setPrice(carDto.getPrice());
        return modelMapper.map(carRepository.save(car),CarDto.class);

    }

    @Override
    public List<Car> getByModel(String model) {

        return carRepository.findByModel(model);

    }

    @Override
    public List<Car> getByModelAndName(String model, String name) {

        return carRepository.findByModelAndName(model,name);
    }

    @Override
    public List<Car> getByPrice(Long price) {
        return carRepository.findByPrice(price);
    }


}
