package com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.dtos.output;

import com.example.block7jpacomrelacionesyllamadasentremicros2.pojos.HistoricoClientes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoClientesOutput {
    int clienteId;
    String nombre;

    public static Object toHistoricoClientesOutput(HistoricoClientes historicoClientes) {
        return new HistoricoClientesOutput(historicoClientes.getClienteId(), historicoClientes.getNombre());
    }
}
