package com.example.block7jpacomrelacionesyllamadasentremicros2.application;

import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.dtos.input.HistoricoVentasInputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.dtos.output.HistoricoVentasOutputDto;

import java.util.List;

public interface HistoricoVentasService {
    public HistoricoVentasOutputDto createHistoricoVentas(HistoricoVentasInputDto historicoVentasInputDto);
    public List<HistoricoVentasOutputDto> readHistoricoVentas(int id);

    public HistoricoVentasOutputDto updateHistoricoVentas(HistoricoVentasInputDto historicoVentasInputDto, int id);
    public void deleteHistoricoVentas(int id);
    public Iterable<HistoricoVentasOutputDto>  findAllHistoricoVentas();
}
