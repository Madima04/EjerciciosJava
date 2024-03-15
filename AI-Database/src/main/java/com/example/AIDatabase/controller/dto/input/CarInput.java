package com.example.AIDatabase.controller.dto.input;

import lombok.Data;

@Data
public class CarInput {
    private String marca;
    private String modelo;
    private String color;
    private String matricula;
    private int precio;
    private String fecha;
}
