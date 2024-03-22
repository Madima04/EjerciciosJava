package com.example.block7jpacomrelacionesyllamadasentremicros2.application.implementation;

import com.example.block7jpacomrelacionesyllamadasentremicros2.application.HistoricoProductosService;
import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.HistoricoProductos;
import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.dtos.output.HistoricoProductosOutput;
import com.example.block7jpacomrelacionesyllamadasentremicros2.repository.HistoricoProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Configuration
public class HistoricoProductosServiceImpl implements HistoricoProductosService {

    @Autowired
    HistoricoProductosRepository historicoProductosRepository;

    @Override
    public HistoricoProductosOutput getHistoricoProducto(int productoId) {
        return historicoProductosRepository.findById(productoId).get().toHistoricoProductosOutput();
    }

    @Override
    public List<HistoricoProductosOutput> getAllHistoricoProducto() {
        List<HistoricoProductosOutput> historicoProductosOutputs = new ArrayList<>();
        List<HistoricoProductos> historicoProductos = historicoProductosRepository.findAll();
        for (HistoricoProductos historicoProducto : historicoProductos) {
            historicoProductosOutputs.add(historicoProducto.toHistoricoProductosOutput());
        }
        return historicoProductosOutputs;
    }
}
