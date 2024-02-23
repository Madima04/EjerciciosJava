package com.example.block7jpacomrelacionesyllamadasentremicros2.application.implementation;

import com.example.block7jpacomrelacionesyllamadasentremicros2.application.HistoricoClienteService;
import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.HistoricoClientes;
import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.dtos.output.HistoricoClientesOutput;
import com.example.block7jpacomrelacionesyllamadasentremicros2.repository.HistoricoClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Configuration
public class HistoricoClienteServiceImpl implements HistoricoClienteService {

    @Autowired
    HistoricoClientesRepository historicoClientesRepository;

    @Override
    public HistoricoClientesOutput getHistoricoCliente(int clienteId) {
        return historicoClientesRepository.findById(clienteId).get().toHistoricoClientesOutput();
    }

    @Override
    public List<HistoricoClientesOutput> getAllHistoricoCliente() {
        List<HistoricoClientesOutput> historicoClientesOutputs = new ArrayList<>();
        List<HistoricoClientes> historicoClientes = historicoClientesRepository.findAll();
        for (HistoricoClientes historicoCliente : historicoClientes) {
            historicoClientesOutputs.add(historicoCliente.toHistoricoClientesOutput());
        }
        return historicoClientesOutputs;
    }
}
