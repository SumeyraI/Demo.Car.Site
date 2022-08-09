package com.car.spring.demo.car.site.api;

import com.car.spring.demo.car.site.dto.CarDto;
import com.car.spring.demo.car.site.entities.Car;
import com.car.spring.demo.car.site.services.impl.ICarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    private final ICarService carService;

    public CarController(ICarService carService) {
        this.carService = carService;
    }

    @GetMapping("/getAllCar")
    public ResponseEntity<List<CarDto>> getAll(){
        return ResponseEntity.ok(carService.getAll());
    }

    @GetMapping({"getById/{id}"})
    public ResponseEntity<CarDto> getById(@PathVariable ("id") Long id){

        return ResponseEntity.ok(carService.getById(id));
    }

    @PostMapping("/createCar")
    public ResponseEntity<CarDto> createCar(@RequestBody CarDto carDto){
        return ResponseEntity.ok(carService.createCar(carDto));
    }
    @DeleteMapping("/deleteCar/{id}")
    public void deleteCar(@PathVariable ("id")  Long id){
        carService.deleteCar(id);
    }
    @PutMapping("/updateCar/{id}")
    public ResponseEntity<CarDto> updateCar(@PathVariable ("id") Long id,@RequestBody CarDto carDto){
        return ResponseEntity.ok(carService.updateCar(id,carDto));
    }

    @GetMapping("/getByModel")
    public ResponseEntity<List<Car>> getByModel(@RequestParam String model){
        return ResponseEntity.ok(carService.getByModel(model));
    }

    @GetMapping("/getByModelAndName")
    // model=hssj&name=ahdja
    public ResponseEntity<List<Car>> getByModelAndName(@RequestParam String model, @RequestParam String name){
        return ResponseEntity.ok(carService.getByModelAndName(model,name));
    }

    @GetMapping("/getByPrice")
    public ResponseEntity<List<Car>> getByPrice(@RequestParam Long price){
        return ResponseEntity.ok(carService.getByPrice(price));
    }

}
