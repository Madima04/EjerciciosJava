package com.example.block7jpacomrelacionesyllamadasentremicros.application;

import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input.ProvinciaInputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.ProvinciaOutputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.ProvinciaOutputDtoImp;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.ProvinciaOutputDtoSimple;

import java.util.List;

public interface ProvinciaService {
    ProvinciaOutputDto getProvinciaById(Long id);
    ProvinciaOutputDtoImp addProvincia(ProvinciaInputDto  provinciaInputDto);
    void deleteProvincia(Long id);
    ProvinciaOutputDtoSimple updateProvincia(ProvinciaInputDto provinciaInputDto, Long id);
    List<ProvinciaOutputDtoSimple> getAllProvincias();
}
