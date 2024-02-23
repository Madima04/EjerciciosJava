package com.example.block7jpacomrelacionesyllamadasentremicros2.pojos;

import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.dtos.output.HistoricoClientesOutput;
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
public class HistoricoClientes {
    @Id
    int clienteId;
    String nombre;

    public HistoricoClientesOutput toHistoricoClientesOutput() {
        return new HistoricoClientesOutput(clienteId, nombre);
    }
}
