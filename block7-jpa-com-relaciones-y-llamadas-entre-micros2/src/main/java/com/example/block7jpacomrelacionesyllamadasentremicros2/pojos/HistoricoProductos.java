package com.example.block7jpacomrelacionesyllamadasentremicros2.pojos;

import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.dtos.output.HistoricoProductosOutput;
import jakarta.persistence.Entity;
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
public class HistoricoProductos {
    @Id
    int idProducto;
    String descripciónProducto;
    double precioProducto;

    public HistoricoProductosOutput toHistoricoProductosOutput() {
        return new HistoricoProductosOutput(idProducto, descripciónProducto);
    }
}
