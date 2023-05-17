package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controlador1")
public class Controlador1 {
    private ServicioPersona servicioPersona;

    @Autowired
    public Controlador1(ServicioPersona servicioPersona) {
        this.servicioPersona = servicioPersona;
    }

    @GetMapping("/addPersona")
    public Persona addPersona(
            @RequestHeader("nombre") String nombre,
            @RequestHeader("poblacion") String poblacion,
            @RequestHeader("edad") int edad) {
        return servicioPersona.crearPersona(nombre, poblacion, edad);
    }
}
