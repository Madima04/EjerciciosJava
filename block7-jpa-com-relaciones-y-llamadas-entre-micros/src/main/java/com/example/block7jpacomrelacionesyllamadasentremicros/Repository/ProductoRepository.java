package com.example.block7jpacomrelacionesyllamadasentremicros.Repository;

import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.LíneasDeFactura;
import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    @Query("SELECT p FROM Producto p WHERE LOWER(p.descripciónProducto) = LOWER(?1)")
    Producto findByDescripciónProducto(String descripciónProducto);
}
