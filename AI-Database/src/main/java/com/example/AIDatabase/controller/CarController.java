package com.example.AIDatabase.controller;

import com.example.AIDatabase.application.CarService;
import com.example.AIDatabase.configuration.openai.ConversationService;
import com.example.AIDatabase.controller.dto.input.CarInput;
import com.example.AIDatabase.domain.Car;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    private final CarService carService;
    private final ConversationService conversationService;

    public CarController(CarService carService, ConversationService conversationService) {
        this.carService = carService;
        this.conversationService = conversationService;
    }

    @PutMapping("/add")
    public void addCar(@RequestBody CarInput carInput) {
        carService.save(carInput);
    }

    @PutMapping("/delete")
    public void deleteCar(long id) {
        carService.deleteById(id);
    }

    @PutMapping("/update")
    public void updateCar(long id, @RequestBody CarInput carInput) {
        carService.updateById(id, carInput);
    }

    @GetMapping("/get/{id}")
    public Car getCar(@RequestParam long id) {
        return carService.findById(id);
    }

    @GetMapping("/get/all")
    public List<Car> getAllCars() {
        return carService.findAll();
    }

    @PutMapping("/fill-in-data")
    public void fillInData() {
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            CarInput carInput = new CarInput();
            carInput.setMarca(faker.company().name());
            carInput.setModelo(faker.company().name());
            carInput.setColor(faker.color().name());
            carInput.setMatricula(faker.idNumber().valid());
            carInput.setPrecio((int) faker.number().randomNumber());
            carInput.setFecha(faker.date().birthday().toString());
            carService.save(carInput);
        }
    }

    @PutMapping("/questionAi")
    public String questionAi(@RequestParam String question) {
        return conversationService.generateResponse(question);
    }

}
