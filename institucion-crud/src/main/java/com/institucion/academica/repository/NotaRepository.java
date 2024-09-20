package com.institucion.academica.repository;

import com.institucion.academica.entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad {@link Nota}.
 * <p>
 * Esta interfaz proporciona los métodos estándar de CRUD y consultas adicionales para la entidad {@code Nota}.
 * Extiende de {@link JpaRepository}, lo que permite realizar operaciones de persistencia en la base de datos
 * sin necesidad de implementar los métodos de acceso a datos manualmente.
 * </p>
 */
@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {
}
