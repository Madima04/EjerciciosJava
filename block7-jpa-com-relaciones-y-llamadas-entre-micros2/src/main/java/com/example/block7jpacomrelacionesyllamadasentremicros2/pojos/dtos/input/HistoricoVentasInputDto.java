package com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.dtos.input;

import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.HistoricoVentas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoVentasInputDto {
    int id;
    int clienteId;
    int productoId;
    int mes;
    int año;
    int cantidad;
    double importe;

    public HistoricoVentasInputDto(int clienteId, int productoId, int mes, int año, int cantidad, double importe) {
        this.clienteId = clienteId;
        this.productoId = productoId;
        this.mes = mes;
        this.año = año;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public HistoricoVentas toHistoricoVentas() {
        return new HistoricoVentas(clienteId+"", productoId+"", mes, año, cantidad, importe);
    }
}
