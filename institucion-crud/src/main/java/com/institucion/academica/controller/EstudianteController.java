package com.institucion.academica.controller;

import com.institucion.academica.entity.Estudiante;
import com.institucion.academica.service.interfaces.EstudianteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {

    private final EstudianteService estudianteService;

    /**
     * Endpoint para listar todos los estudiantes.
     *
     * @return Lista de todos los estudiantes en la base de datos.
     */
    @GetMapping
    public List<Estudiante> listarEstudiantes() {
        return estudianteService.listarEstudiantes();
    }

    /**
     * Endpoint para obtener un estudiante por su ID.
     *
     * @param id del estudiante.
     * @return El estudiante correspondiente si existe, o un 404 si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiantePorId(@PathVariable Long id) {
        Estudiante estudiante = estudianteService.buscarEstudiantePorId(id);
        return ResponseEntity.ok(estudiante);
    }

    /**
     * Endpoint para crear un nuevo estudiante.
     *
     * @param estudiante Objeto {@link Estudiante} a crear.
     * @return El estudiante creado con el código de estado 201 (Created).
     */
    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante nuevoEstudiante = estudianteService.guardarEstudiante(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEstudiante);
    }

    /**
     * Endpoint para actualizar un estudiante existente por su ID.
     *
     * @param id                    del estudiante a actualizar.
     * @param estudianteActualizado Objeto {@link Estudiante} con los datos actualizados.
     * @return El estudiante actualizado, o un 404 si no se encuentra.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudianteActualizado) {
        Estudiante estudiante = estudianteService.actualizarEstudiante(id, estudianteActualizado);
        return ResponseEntity.ok(estudiante);
    }

    /**
     * Endpoint para eliminar un estudiante por su ID.
     *
     * @param id del estudiante a eliminar.
     * @return Código de estado 204 (No Content) si se elimina exitosamente, o un 404 si no se encuentra.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        try {
            estudianteService.eliminarEstudiante(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
