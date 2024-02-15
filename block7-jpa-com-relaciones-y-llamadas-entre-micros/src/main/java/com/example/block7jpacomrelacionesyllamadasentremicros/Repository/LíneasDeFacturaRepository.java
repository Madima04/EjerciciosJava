package com.example.block7jpacomrelacionesyllamadasentremicros.Repository;

import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input.LíneasDeFacturaInputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.CabecerasDeFactura;
import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.LíneasDeFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface LíneasDeFacturaRepository extends JpaRepository<LíneasDeFactura, Integer> {
    @Query("SELECT l FROM LíneasDeFactura l WHERE l.cabecerasDeFactura = ?1")
    Set<LíneasDeFactura> findAllByCabecera(CabecerasDeFactura cabecerasDeFactura);
}
