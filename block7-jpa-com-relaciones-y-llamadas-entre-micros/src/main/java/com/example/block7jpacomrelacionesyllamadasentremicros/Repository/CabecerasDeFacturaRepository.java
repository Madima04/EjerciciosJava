package com.example.block7jpacomrelacionesyllamadasentremicros.Repository;

import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input.CabecerasDeFacturaInputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.CabecerasDeFacturaOutputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.CabecerasDeFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Set;

public interface CabecerasDeFacturaRepository extends JpaRepository<CabecerasDeFactura, Integer> {
    @Query("SELECT c FROM CabecerasDeFactura c WHERE c.cliente.DNI = ?1 AND c.fecha BETWEEN ?2 AND ?3")
    CabecerasDeFactura findByClienteInDateRange(int dni, Date fechaInicio, Date fechaFin);
    @Query("SELECT c FROM CabecerasDeFactura c join c.líneasDeFactura l WHERE l.producto.idProducto = ?1")
    CabecerasDeFactura findByCodigoProducto(String codigoProducto);
}
