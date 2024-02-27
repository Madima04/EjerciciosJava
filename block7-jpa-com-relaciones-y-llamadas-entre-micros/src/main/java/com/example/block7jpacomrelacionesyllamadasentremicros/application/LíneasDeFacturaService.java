package com.example.block7jpacomrelacionesyllamadasentremicros.application;

import org.example.dtos.input.LíneasDeFacturaInputDto;
import org.example.dtos.output.LíneasDeFacturaOutputDto;

public interface LíneasDeFacturaService {
    LíneasDeFacturaOutputDto getLíneasDeFactura(Long id);
    LíneasDeFacturaOutputDto addLíneasDeFactura(LíneasDeFacturaInputDto líneasDeFacturaInputDto);
    void deleteLíneasDeFactura(Long id);
    LíneasDeFacturaOutputDto updateLíneasDeFactura(LíneasDeFacturaInputDto líneasDeFacturaInputDto, Long id);
    Iterable<LíneasDeFacturaOutputDto> getAllLíneasDeFactura();
}
