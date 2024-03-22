package com.example.block7jpacomrelacionesyllamadasentremicros.controller;

import com.example.block7jpacomrelacionesyllamadasentremicros.application.implementation.LíneasDeFacturaServiceImpl;
import org.example.dtos.input.LíneasDeFacturaInputDto;
import org.example.dtos.output.LíneasDeFacturaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lineasDeFactura")
public class ControllerLineasDeFactura {
    @Autowired
    private LíneasDeFacturaServiceImpl líneasDeFacturaService;

    @GetMapping(value ="/GetAllLineasDeFactura")
    public Iterable<LíneasDeFacturaOutputDto> getAllLineasDeFactura() {
        return líneasDeFacturaService.getAllLíneasDeFactura();
    }


    @GetMapping(value = "/GetLineaDeFactura/{id}")
    public LíneasDeFacturaOutputDto getLineaDeFactura(Long id) {
        return líneasDeFacturaService.getLíneasDeFactura(id);
    }

    @GetMapping(value = "/AddLineaDeFactura")
    public LíneasDeFacturaOutputDto addLineaDeFactura(LíneasDeFacturaInputDto líneasDeFactura) {
        return líneasDeFacturaService.addLíneasDeFactura(líneasDeFactura);
    }

    @GetMapping(value = "/DeleteLineaDeFactura/{id}")
    public void deleteLineaDeFactura(Long id) {
        líneasDeFacturaService.deleteLíneasDeFactura(id);
    }

    @GetMapping(value = "/UpdateLineaDeFactura/{id}")
    public LíneasDeFacturaOutputDto updateLineaDeFactura(LíneasDeFacturaInputDto líneasDeFactura, Long id) {
        return líneasDeFacturaService.updateLíneasDeFactura(líneasDeFactura, id);
    }
}
