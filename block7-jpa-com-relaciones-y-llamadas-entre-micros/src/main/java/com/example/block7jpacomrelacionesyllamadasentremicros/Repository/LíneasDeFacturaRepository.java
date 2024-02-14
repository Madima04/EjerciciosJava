package com.example.block7jpacomrelacionesyllamadasentremicros.Repository;

import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input.LíneasDeFacturaInputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.LíneasDeFactura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface LíneasDeFacturaRepository extends JpaRepository<LíneasDeFactura, Integer> {
}
