package com.example.AIDatabase.repository;

import com.example.AIDatabase.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
