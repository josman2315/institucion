package com.institucion.academica.repository;

import com.institucion.academica.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


/**
 * Repositorio para la entidad {@link Estudiante}.
 * <p>
 * Esta interfaz proporciona los métodos estándar de CRUD y consultas adicionales para la entidad {@code Estudiante}.
 * Extiende de {@link JpaRepository}, lo que permite realizar operaciones de persistencia en la base de datos
 * sin necesidad de implementar los métodos de acceso a datos manualmente.
 * </p>
 */

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}