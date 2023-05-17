package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controlador2")
public class Controlador2 {
    private ServicioPersona servicioPersona;

    @Autowired
    public Controlador2(ServicioPersona servicioPersona) {
        this.servicioPersona = servicioPersona;
    }

    @GetMapping("/getPersona")
    public Persona getPersona() {
        Persona persona = servicioPersona.getPersona();
        persona.setEdad(persona.getEdad() * 2);
        return persona;
    }
}



