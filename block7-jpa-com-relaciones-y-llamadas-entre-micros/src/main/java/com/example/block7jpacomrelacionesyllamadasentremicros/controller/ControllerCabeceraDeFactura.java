package com.example.block7jpacomrelacionesyllamadasentremicros.controller;

import com.example.block7jpacomrelacionesyllamadasentremicros.application.implementation.CabecerasDeFacturaServiceImpl;
import org.example.dtos.input.CabecerasDeFacturaInputDto;
import org.example.dtos.output.CabecerasDeFacturaOutputDto;
import org.example.dtos.output.CabecerasDeFacturaOutputDtoSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CabeceraDeFactura")
public class ControllerCabeceraDeFactura {

    @Autowired
    private CabecerasDeFacturaServiceImpl cabecerasDeFacturaService;

    @GetMapping(value = "/GetAllCabecerasDeFactura")
    public Iterable<CabecerasDeFacturaOutputDto> getAllCabecerasDeFactura() {
        return cabecerasDeFacturaService.getAllCabecerasDeFactura();
    }

    @PostMapping(value = "/addCabeceraDeFactura")
    public CabecerasDeFacturaOutputDto addCabeceraDeFactura(@RequestBody CabecerasDeFacturaInputDto cabecerasDeFactura) {
        return cabecerasDeFacturaService.addCabeceraDeFactura(cabecerasDeFactura);
    }

    @GetMapping(value = "/GetCabeceraDeFactura/{id}")
    public CabecerasDeFacturaOutputDto getCabeceraDeFactura(@PathVariable Long id) {
        return cabecerasDeFacturaService.getCabeceraDeFactura(id);
    }

    @DeleteMapping(value = "/DeleteCabeceraDeFactura/{id}")
    public void deleteCabeceraDeFactura(@PathVariable int id) {
        cabecerasDeFacturaService.deleteCabeceraDeFactura(id);
    }

    @PutMapping(value = "/UpdateCabeceraDeFactura")
    public CabecerasDeFacturaOutputDto updateCabeceraDeFactura(@RequestBody CabecerasDeFacturaInputDto cabecerasDeFactura, @PathVariable Long id) {
        return cabecerasDeFacturaService.updateCabeceraDeFactura(cabecerasDeFactura, id);
    }

    @GetMapping(value = "/GetCabeceraDeFacturaByClienteInDateRange")
    public CabecerasDeFacturaOutputDtoSimple getCabeceraDeFacturaByClienteInDateRange(@RequestParam int dni, @RequestParam String fechaInicio, @RequestParam String fechaFin) {
        return cabecerasDeFacturaService.getCabeceraDeFacturaByClienteInDateRange(dni, fechaInicio, fechaFin);
    }
}
