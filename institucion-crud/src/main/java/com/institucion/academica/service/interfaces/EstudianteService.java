package com.institucion.academica.service.interfaces;

import com.institucion.academica.entity.Estudiante;
import java.util.List;

/**
 * Interfaz para el servicio de {@link Estudiante}.
 * <p>
 * Esta interfaz define las operaciones de negocio para la entidad {@code Estudiante}, incluyendo
 * la gestión de notas como listar, guardar, actualizar, eliminar y buscar por ID.
 * </p>
 */
public interface EstudianteService {

    List<Estudiante> listarEstudiantes();

    Estudiante buscarEstudiantePorId(Long id);

    Estudiante guardarEstudiante(Estudiante estudiante);

    Estudiante actualizarEstudiante(Long id, Estudiante estudiante);

    void eliminarEstudiante(Long id);
}
