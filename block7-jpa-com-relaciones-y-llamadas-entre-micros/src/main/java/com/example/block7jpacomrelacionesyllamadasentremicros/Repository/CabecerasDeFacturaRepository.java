package com.example.block7jpacomrelacionesyllamadasentremicros.Repository;

import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input.CabecerasDeFacturaInputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.CabecerasDeFacturaOutputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.CabecerasDeFactura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CabecerasDeFacturaRepository extends JpaRepository<CabecerasDeFactura, Integer> {
}
