package com.example.block7jpacomrelacionesyllamadasentremicros2.application;

import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.dtos.output.HistoricoClientesOutput;

import java.util.List;

public interface HistoricoClienteService {
    public HistoricoClientesOutput getHistoricoCliente(int clienteId);
    public List<HistoricoClientesOutput> getAllHistoricoCliente();
}
