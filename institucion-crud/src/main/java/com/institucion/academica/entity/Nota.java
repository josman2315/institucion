package com.institucion.academica.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Representa una entidad de Nota en la base de datos.
 * <p>
 * Esta clase está mapeada a la tabla {@code nota} y contiene la información relacionada con una nota,
 * incluyendo un identificador único, el nombre de la nota, el valor asociado a la nota, y las referencias
 * a los profesores y estudiantes relacionados.
 * </p>
 */
@Data
@Entity
@Table(name = "notas")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNota;

    @Column(nullable = false)
    private String nombreNota;

    @Column(nullable = false)
    private Double valor;

    /**
     * Profesor relacionado con la nota.
     * <p>
     * Este campo es una clave foránea que hace referencia a un registro en la tabla {@code profesor}.
     * </p>
     */
    @ManyToOne
    @JoinColumn(name = "id_profesor", referencedColumnName = "id_profesor", foreignKey = @ForeignKey(name = "fk_nota_profesor"))
    private Profesor profesor;

    /**
     * Estudiante relacionado con la nota.
     * <p>
     * Este campo es una clave foránea que hace referencia a un registro en la tabla {@code estudiante}.
     * </p>
     */
    @ManyToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id_estudiante", foreignKey = @ForeignKey(name = "fk_nota_estudiante"))
    private Estudiante estudiante;

}
