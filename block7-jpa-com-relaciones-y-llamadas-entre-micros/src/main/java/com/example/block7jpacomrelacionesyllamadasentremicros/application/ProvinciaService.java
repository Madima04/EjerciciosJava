package com.example.block7jpacomrelacionesyllamadasentremicros.application;

import org.example.dtos.input.ProvinciaInputDto;
import org.example.dtos.output.ProvinciaOutputDto;
import org.example.dtos.output.ProvinciaOutputDtoImp;
import org.example.dtos.output.ProvinciaOutputDtoSimple;

import java.util.List;

public interface ProvinciaService {
    ProvinciaOutputDto getProvinciaById(Long id);
    ProvinciaOutputDtoImp addProvincia(ProvinciaInputDto provinciaInputDto);
    void deleteProvincia(Long id);
    ProvinciaOutputDtoSimple updateProvincia(ProvinciaInputDto provinciaInputDto, Long id);
    List<ProvinciaOutputDtoSimple> getAllProvincias();
}
