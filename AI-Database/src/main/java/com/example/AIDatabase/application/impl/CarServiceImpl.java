package com.example.AIDatabase.application.impl;

import com.example.AIDatabase.application.CarService;
import com.example.AIDatabase.controller.dto.input.CarInput;
import com.example.AIDatabase.domain.Car;
import com.example.AIDatabase.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public Car save(CarInput car) {
        Car newCar = new Car();
        newCar.setMarca(car.getMarca());
        newCar.setModelo(car.getModelo());
        newCar.setColor(car.getColor());
        newCar.setMatricula(car.getMatricula());
        newCar.setPrecio(car.getPrecio());
        newCar.setFecha(car.getFecha());
        return carRepository.save(newCar);
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Car updateById(Long id, CarInput car) {
        Car carToUpdate = carRepository.findById(id).orElse(null);
        if (carToUpdate != null) {
            carToUpdate.setMarca(car.getMarca());
            carToUpdate.setModelo(car.getModelo());
            carToUpdate.setColor(car.getColor());
            carToUpdate.setMatricula(car.getMatricula());
            carToUpdate.setPrecio(car.getPrecio());
            carToUpdate.setFecha(car.getFecha());
            return carRepository.save(carToUpdate);
        }
        return null;
    }

    @Override
    public String questionAi() {
        return null;
    }
}
