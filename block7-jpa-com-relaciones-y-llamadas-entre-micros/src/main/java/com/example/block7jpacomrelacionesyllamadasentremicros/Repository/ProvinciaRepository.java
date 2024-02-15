package com.example.block7jpacomrelacionesyllamadasentremicros.Repository;

import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProvinciaRepository extends JpaRepository<Provincia, Integer> {
    @Query("SELECT p FROM Provincia p WHERE p.nombreProvincia = ?1")
    Provincia findByNombre(String nombre);
}
