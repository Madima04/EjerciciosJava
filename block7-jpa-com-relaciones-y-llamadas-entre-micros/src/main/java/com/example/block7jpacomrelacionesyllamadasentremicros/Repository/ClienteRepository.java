package com.example.block7jpacomrelacionesyllamadasentremicros.Repository;

import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.Cliente;
import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Set<Cliente> findByProvincia(Provincia provincia);
    @Query("SELECT c FROM Cliente c WHERE LOWER(c.nombre) = LOWER(?1)")
    Cliente findByNombre(String nombre);
}
