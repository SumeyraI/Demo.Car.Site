package com.car.spring.demo.car.site.api;

import com.car.spring.demo.car.site.dto.CarDto;
import com.car.spring.demo.car.site.dto.CarNameRequest;
import com.car.spring.demo.car.site.entities.Car;
import com.car.spring.demo.car.site.exception.CarNotFoundException;
import com.car.spring.demo.car.site.services.impl.ICarService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/getByName")
    public ResponseEntity<CarNameRequest> getByName(@RequestParam String name){

        return ResponseEntity.ok(carService.getByName(name));
    }

    @GetMapping("/getPageable")
    public ResponseEntity<List<CarDto>> pageCar(Pageable pageable){
        return ResponseEntity.ok(carService.pageCar(pageable));
    }

    @GetMapping("/getByStock")
    public ResponseEntity<List<Car>> getByStock(@RequestParam int stock){
        return ResponseEntity.ok(carService.getByStock(stock));
    }

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<String> handleCarNotFoundException(CarNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }



}
