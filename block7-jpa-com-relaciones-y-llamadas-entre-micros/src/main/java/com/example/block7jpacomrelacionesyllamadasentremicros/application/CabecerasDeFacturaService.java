package com.example.block7jpacomrelacionesyllamadasentremicros.application;

import org.example.dtos.input.CabecerasDeFacturaInputDto;
import org.example.dtos.output.CabecerasDeFacturaOutputDto;

import java.util.List;

public interface CabecerasDeFacturaService {
    CabecerasDeFacturaOutputDto addCabeceraDeFactura(CabecerasDeFacturaInputDto studentInputDto);
    CabecerasDeFacturaOutputDto getCabeceraDeFactura(Long id);
    void deleteCabeceraDeFactura(int id);
    CabecerasDeFacturaOutputDto updateCabeceraDeFactura(CabecerasDeFacturaInputDto studentInputDto, Long id);
    List<CabecerasDeFacturaOutputDto> getAllCabecerasDeFactura();

}
