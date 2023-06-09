package com.example.Ejercicio7_Validacion;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    Integer id_profesor;
    @OneToOne
    @JoinColumn(name="persona_id")
    Persona persona;
    @NotNull
    String branch;
}