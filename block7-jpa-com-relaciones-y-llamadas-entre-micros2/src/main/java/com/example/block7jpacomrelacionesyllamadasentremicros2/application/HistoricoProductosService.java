package com.example.block7jpacomrelacionesyllamadasentremicros2.application;

import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.dtos.output.HistoricoProductosOutput;

import java.util.List;

public interface HistoricoProductosService {
    public HistoricoProductosOutput getHistoricoProducto(int productoId);
    public List<HistoricoProductosOutput> getAllHistoricoProducto();
}
