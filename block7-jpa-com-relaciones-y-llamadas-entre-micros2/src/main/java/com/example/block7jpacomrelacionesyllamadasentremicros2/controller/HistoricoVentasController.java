package com.example.block7jpacomrelacionesyllamadasentremicros2.controller;

import com.example.block7jpacomrelacionesyllamadasentremicros2.application.HistoricoVentasService;
import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.dtos.output.HistoricoVentasOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/HistoricoVentas")
public class HistoricoVentasController {

    @Autowired
    public HistoricoVentasController(HistoricoVentasService historicoVentasService) {
        this.historicoVentasService = historicoVentasService;
    }
    private final HistoricoVentasService historicoVentasService;

    @GetMapping("/findById/{id}")
    public List<HistoricoVentasOutputDto> findById(@PathVariable int id) {
        return historicoVentasService.readHistoricoVentas(id);
    }
}
