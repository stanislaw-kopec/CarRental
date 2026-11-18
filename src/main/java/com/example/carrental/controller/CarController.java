package com.example.carrental.controller;

import com.example.carrental.model.Car;
import com.example.carrental.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @GetMapping
    public List<Car> getCars() {
        return carService.findAll();
    }

    @GetMapping("/{registrationNumber}")
    public Car getCar(@PathVariable String registrationNumber) {
        return carService.findByRegistrationNumber(registrationNumber);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car createCar(@RequestBody Car car) {
        return carService.save(car);
    }

    @PutMapping("/{registrationNumber}")
    @ResponseStatus(HttpStatus.CREATED)
    public Car updateCar(
            @PathVariable String registrationNumber,
            @RequestBody Car car) {
        return carService.update(registrationNumber, car);
    }

    @DeleteMapping("/{registrationNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable String registrationNumber) {
        carService.delete(registrationNumber);
    }

    @GetMapping("/brand/{brand}")
    public List<Car> getCarsByBrand(@PathVariable String brand) {
        return carService.findByBrand(brand);
    }



}
