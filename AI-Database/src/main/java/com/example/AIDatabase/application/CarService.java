package com.example.AIDatabase.application;

import com.example.AIDatabase.controller.dto.input.CarInput;
import com.example.AIDatabase.domain.Car;

import java.util.List;

public interface CarService {
    public List<Car> findAll();
    public Car findById(Long id);
    public Car save(CarInput car);
    public void deleteById(Long id);
    public Car updateById(Long id, CarInput car);

    String questionAi();
}
