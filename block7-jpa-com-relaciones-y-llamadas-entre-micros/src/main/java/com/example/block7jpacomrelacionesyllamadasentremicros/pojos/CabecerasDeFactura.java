package com.example.block7jpacomrelacionesyllamadasentremicros.pojos;

import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.CabecerasDeFacturaOutputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.LíneasDeFacturaOutputDtoSimple;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.*;

import java.util.*;

@Entity
@Getter
@Setter
public class CabecerasDeFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCabecera;
    private Date fecha;
    private Float importeTotalFactura;
    @ManyToOne
    @JoinColumn(name = "DNI")
    private Cliente cliente;
    @OneToMany(mappedBy = "cabecerasDeFactura", fetch = FetchType.LAZY)
    private Set<LíneasDeFactura> líneasDeFactura;



    public CabecerasDeFacturaOutputDto toOutputDto() {
        Set<LíneasDeFacturaOutputDtoSimple> líneasDeFacturaOutputDtos = new HashSet<>();
        CabecerasDeFacturaOutputDto cabecerasDeFacturaOutputDto = new CabecerasDeFacturaOutputDto();
        cabecerasDeFacturaOutputDto.setIdCabecera(this.idCabecera);
        cabecerasDeFacturaOutputDto.setFecha(this.fecha);
        cabecerasDeFacturaOutputDto.setImporteTotalFactura(this.importeTotalFactura);
        cabecerasDeFacturaOutputDto.setCliente(this.cliente.toOutputDtoSimple());
        for (LíneasDeFactura líneasDeFactura : this.líneasDeFactura) {
            líneasDeFacturaOutputDtos.add(líneasDeFactura.toOutputDtoSimple());
        }
        cabecerasDeFacturaOutputDto.setLíneasDeFactura(líneasDeFacturaOutputDtos);
        return cabecerasDeFacturaOutputDto;
    }

    public CabecerasDeFacturaOutputDto toOutputDtoSimple() {
        CabecerasDeFacturaOutputDto cabecerasDeFacturaOutputDto = new CabecerasDeFacturaOutputDto();
        cabecerasDeFacturaOutputDto.setIdCabecera(this.idCabecera);
        cabecerasDeFacturaOutputDto.setFecha(this.fecha);
        cabecerasDeFacturaOutputDto.setImporteTotalFactura(this.importeTotalFactura);
        cabecerasDeFacturaOutputDto.setCliente(this.cliente.toOutputDtoSimple());
        return cabecerasDeFacturaOutputDto;
    }
}
