package com.example.block7jpacomrelacionesyllamadasentremicros.Repository;

import com.example.block7jpacomrelacionesyllamadasentremicros.pojos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
