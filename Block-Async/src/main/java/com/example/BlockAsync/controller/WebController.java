package com.example.BlockAsync.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/")
    public String home() {
        return "index"; // Retorna el nombre de la plantilla HTML sin la extensión
    }
}
