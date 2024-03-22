package com.example.block7jpacomrelacionesyllamadasentremicros2.repository;

import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.HistoricoProductos;
import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.HistoricoVentas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoProductosRepository extends JpaRepository<HistoricoProductos, Integer> {
}
