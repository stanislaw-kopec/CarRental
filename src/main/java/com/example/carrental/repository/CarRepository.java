package com.example.carrental.repository;

import com.example.carrental.exception.CarNotFoundException;
import com.example.carrental.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CarRepository {

    private final List<Car> cars = new ArrayList<>(List.of(
            new Car("KWI12321", "Alfa Romeo", "Stelvio", 2020, "czerwony", 56700, 600.0),
            new Car("KR777888", "Ford", "Focus", 2021, "niebieski", 65000, 400.0),
            new Car("KK90909", "Skoda", "Scala", 2022, "szary", 44000, 450.0)
    ));

    public List<Car> findAll() {
        return cars;
    }

    public Optional<Car> findByRegistrationNumber(String registrationNumber) {
        return cars.stream().filter(car -> car.getRegistrationNumber().equals(registrationNumber)).findFirst();
    }

    public Car save(Car car) {
        cars.add(car);
        return car;
    }

    public boolean deleteByRegistrationNumber(String registrationNumber) {
        return findByRegistrationNumber(registrationNumber).map(cars::remove).orElse(false);
    }

    public List<Car> findByBrand(String brand) {
        return cars.stream()
                .filter(car -> brand.equalsIgnoreCase(car.getBrand()))
                .toList();
    }
}
