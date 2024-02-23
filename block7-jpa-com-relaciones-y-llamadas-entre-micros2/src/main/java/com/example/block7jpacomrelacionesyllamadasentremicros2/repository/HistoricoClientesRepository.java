package com.example.block7jpacomrelacionesyllamadasentremicros2.repository;

import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.HistoricoClientes;
import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.dtos.output.HistoricoClientesOutput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HistoricoClientesRepository extends JpaRepository<HistoricoClientes, Integer> {
}
