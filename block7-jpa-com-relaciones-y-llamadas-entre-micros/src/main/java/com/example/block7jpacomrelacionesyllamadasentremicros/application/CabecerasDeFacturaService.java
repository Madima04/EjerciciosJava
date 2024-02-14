package com.example.block7jpacomrelacionesyllamadasentremicros.application;

import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input.CabecerasDeFacturaInputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.CabecerasDeFacturaOutputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.CabecerasDeFactura;

import java.util.List;

public interface CabecerasDeFacturaService {
    CabecerasDeFactura addCabeceraDeFactura(CabecerasDeFacturaInputDto studentInputDto);
    CabecerasDeFacturaOutputDto getCabeceraDeFactura(Long id);
    void deleteCabeceraDeFactura(int id);
    CabecerasDeFacturaOutputDto updateCabeceraDeFactura(CabecerasDeFacturaInputDto studentInputDto, Long id);
    List<CabecerasDeFactura> getAllCabecerasDeFactura();

}
