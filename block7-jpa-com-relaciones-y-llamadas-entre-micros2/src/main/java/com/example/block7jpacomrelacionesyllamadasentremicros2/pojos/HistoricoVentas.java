package com.example.block7jpacomrelacionesyllamadasentremicros2.pojos;

import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.dtos.output.HistoricoVentasOutputDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoVentas {
    @Id
    @GeneratedValue
    int id;
    String clienteId;
    String productoId;
    int mes;
    int año;
    int cantidad;
    double importe;

    public HistoricoVentas(String clienteId, String productoId, int mes, int año, int cantidad, double importe) {
        this.clienteId = clienteId;
        this.productoId = productoId;
        this.mes = mes;
        this.año = año;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public HistoricoVentasOutputDto toHistoricoVentasOutputDto() {
        return new HistoricoVentasOutputDto(id, clienteId+"", productoId+"", mes, año, cantidad, importe);
    }
}
