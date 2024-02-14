package com.example.block7jpacomrelacionesyllamadasentremicros.application;

import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input.LíneasDeFacturaInputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.LíneasDeFacturaOutputDto;

public interface LíneasDeFacturaService {
    LíneasDeFacturaOutputDto getLíneasDeFactura(Long id);
    LíneasDeFacturaOutputDto addLíneasDeFactura(LíneasDeFacturaInputDto líneasDeFacturaInputDto);
    void deleteLíneasDeFactura(Long id);
    LíneasDeFacturaOutputDto updateLíneasDeFactura(LíneasDeFacturaInputDto líneasDeFacturaInputDto, Long id);
    Iterable<LíneasDeFacturaOutputDto> getAllLíneasDeFactura();
}
