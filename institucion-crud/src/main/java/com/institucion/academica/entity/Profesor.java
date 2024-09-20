package com.institucion.academica.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Representa una entidad de Profesor en la base de datos.
 * <p>
 * Esta clase está mapeada a la tabla {@code profesor} y contiene la información de un profesor,
 * incluyendo un identificador único y el nombre del profesor.
 * </p>
 */
@Data
@Entity
@Table(name = "profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor", nullable = false)
    private Long idProfesor;

    @Column(name = "nombre_profesor", nullable = false)
    private String nombreProfesor;
}
