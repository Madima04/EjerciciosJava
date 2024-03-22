package com.example.AIDatabase.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {
    @Id
    @GeneratedValue
    private Long id;
    private String marca;
    private String modelo;
    private String color;
    private String matricula;
    private int precio;
    private String fecha;
}
