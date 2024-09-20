package com.institucion.academica.service.interfaces;

import com.institucion.academica.entity.Profesor;

import java.util.List;

/**
 * Interfaz para el servicio de {@link Profesor}.
 * <p>
 * Esta interfaz define las operaciones de negocio para la entidad {@code Profesor}, incluyendo
 * la gestión de profesores como listar, guardar, actualizar, eliminar y buscar por ID.
 * </p>
 */
public interface ProfesorService {

    List<Profesor> listarProfesores();

    Profesor buscarProfesorPorId(Long id);

    Profesor guardarProfesor(Profesor profesor);

    Profesor actualizarProfesor(Long id, Profesor profesor);

    void eliminarProfesor(Long id);
}
