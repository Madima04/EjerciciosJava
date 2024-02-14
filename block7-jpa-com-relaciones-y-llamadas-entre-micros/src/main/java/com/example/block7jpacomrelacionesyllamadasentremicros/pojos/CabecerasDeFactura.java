package com.example.block7jpacomrelacionesyllamadasentremicros.pojos;

import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.input.CabecerasDeFacturaInputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.CabecerasDeFacturaOutputDto;
import com.example.block7jpacomrelacionesyllamadasentremicros.controller.dtos.output.LíneasDeFacturaOutputDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabecerasDeFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCabecera;
    @Future
    private Date fecha;
    private Float importeTotalFactura;
    @ManyToOne
    @JoinColumn(name = "DNI")
    private Cliente cliente;
    @OneToMany(mappedBy = "cabecerasDeFactura", fetch = FetchType.LAZY)
    private Set<LíneasDeFactura> líneasDeFactura;



    public CabecerasDeFacturaOutputDto toOutputDto() {
        CabecerasDeFacturaOutputDto cabecerasDeFacturaOutputDto = new CabecerasDeFacturaOutputDto();
        cabecerasDeFacturaOutputDto.setIdCabecera(this.idCabecera);
        cabecerasDeFacturaOutputDto.setFecha(this.fecha);
        cabecerasDeFacturaOutputDto.setImporteTotalFactura(this.importeTotalFactura);
        cabecerasDeFacturaOutputDto.setCliente(this.cliente.toOutputDtoSimple());
        cabecerasDeFacturaOutputDto.setLíneasDeFactura(this.líneasDeFactura.stream().map(LíneasDeFactura::toOutputDto).collect(Collectors.toSet()));
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
