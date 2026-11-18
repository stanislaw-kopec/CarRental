package com.example.carrental.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@AllArgsConstructor
public class Car {
    @UniqueElements
    private String registrationNumber;
    private String brand;
    private String model;
    private int productionYear;
    private String color;
    private int mileage;
    private double pricePerDay;
}
