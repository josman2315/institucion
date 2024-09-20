package com.institucion.academica.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Representa una entidad de Estudiante en la base de datos.
 * <p>
 * Esta clase está mapeada a la tabla {@code estudiante} y contiene la información de un estudiante,
 * incluyendo un identificador único y el nombre del estudiante.
 * </p>
 */
@Data
@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante", nullable = false)
    private Long idEstudiante;

    @Column(name = "nombre_estudiante", nullable = false)
    private String nombreEstudiante;
}
