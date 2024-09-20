package com.institucion.academica.service.interfaces;

import com.institucion.academica.entity.Nota;

import java.util.List;

/**
 * Interfaz para el servicio de {@link Nota}.
 * <p>
 * Esta interfaz define las operaciones de negocio para la entidad {@code Nota}, incluyendo
 * la gestión de notas como listar, guardar, actualizar, eliminar y buscar por ID.
 * </p>
 */
public interface NotaService {

    List<Nota> listarNotas();

    Nota buscarNotaPorId(Long id);

    Nota guardarNota(Nota nota);

    Nota actualizarNota(Long id, Nota nota);

    void eliminarNota(Long id);
}
