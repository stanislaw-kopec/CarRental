package com.example.carrental.service;

import com.example.carrental.exception.CarAlreadyExistsException;
import com.example.carrental.exception.CarNotFoundException;
import com.example.carrental.exception.InvalidCarException;
import com.example.carrental.model.Car;
import com.example.carrental.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car findByRegistrationNumber(String registrationNumber) {
        return carRepository.findByRegistrationNumber(registrationNumber)
                .orElseThrow(() -> new CarNotFoundException(registrationNumber));
    }

    public  Car save(Car car) {
        if (carRepository.findByRegistrationNumber(
                car.getRegistrationNumber()).isPresent()) {
            throw new CarAlreadyExistsException(car.getRegistrationNumber());
        }
        if (car.getProductionYear() > Year.now().getValue()) {
            throw new InvalidCarException(
                    "The year of manufacture cannot be in the future"
            );
        }
        if (car.getPricePerDay() <= 0) {
            throw new InvalidCarException(
                    "The price per day must be greater than 0"
            );
        }
        return carRepository.save(car);
    }

    public void delete(String registrationNumber) {
        if (!carRepository.deleteByRegistrationNumber(registrationNumber)) {
            throw new CarNotFoundException(registrationNumber);
        }
    }

    public Car update(String registrationNumber, Car updatedCar) {
        Car existingCar = findByRegistrationNumber(registrationNumber);
        existingCar.setBrand(updatedCar.getBrand());
        existingCar.setModel(updatedCar.getModel());
        existingCar.setProductionYear(updatedCar.getProductionYear());
        existingCar.setColor(updatedCar.getColor());
        existingCar.setMileage(updatedCar.getMileage());
        existingCar.setPricePerDay(updatedCar.getPricePerDay());
        return existingCar;
    }

    public List<Car> findByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }
}
