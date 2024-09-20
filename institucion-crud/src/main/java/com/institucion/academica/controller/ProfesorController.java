package com.institucion.academica.controller;

import com.institucion.academica.entity.Profesor;
import com.institucion.academica.service.interfaces.ProfesorService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
@RequiredArgsConstructor
public class ProfesorController {

    private final ProfesorService profesorService;

    /**
     * Endpoint para listar todos los profesores.
     *
     * @return Lista de todos los profesores en la base de datos.
     */
    @GetMapping
    public List<Profesor> listarProfesores() {
        return profesorService.listarProfesores();
    }

    /**
     * Endpoint para obtener un profesor por su ID.
     *
     * @param id del profesor.
     * @return El profesor correspondiente si existe, o un 404 si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtenerProfesorPorId(@PathVariable Long id) {
        Profesor profesor = profesorService.buscarProfesorPorId(id);
        return ResponseEntity.ok(profesor);
    }

    /**
     * Endpoint para crear un nuevo profesor.
     *
     * @param profesor Objeto {@link Profesor} a crear.
     * @return El profesor creado con el código de estado 201 (Created).
     */
    @PostMapping
    public ResponseEntity<Profesor> crearProfesor(@RequestBody Profesor profesor) {
        Profesor nuevoProfesor = profesorService.guardarProfesor(profesor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProfesor);
    }

    /**
     * Endpoint para actualizar un profesor existente por su ID.
     *
     * @param id del profesor a actualizar.
     * @param profesorActualizado Objeto {@link Profesor} con los datos actualizados.
     * @return El profesor actualizado, o un 404 si no se encuentra.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Profesor> actualizarProfesor(@PathVariable Long id, @RequestBody Profesor profesorActualizado) {
        try {
            Profesor profesor = profesorService.actualizarProfesor(id, profesorActualizado);
            return ResponseEntity.ok(profesor);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * Endpoint para eliminar un profesor por su ID.
     *
     * @param id del profesor a eliminar.
     * @return Código de estado 204 (No Content) si se elimina exitosamente, o un 404 si no se encuentra.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProfesor(@PathVariable Long id) {
        try {
            profesorService.eliminarProfesor(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
