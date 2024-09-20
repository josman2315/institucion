package com.institucion.academica.controller;

import com.institucion.academica.entity.Nota;
import com.institucion.academica.service.interfaces.NotaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/notas")
@RequiredArgsConstructor
public class NotaController {

    private final NotaService notaService;

    /**
     * Endpoint para listar todas las notas.
     *
     * @return Lista de todas las notas en la base de datos.
     */
    @GetMapping
    public List<Nota> listarNotas() {
        return notaService.listarNotas();
    }

    /**
     * Endpoint para obtener una nota por su ID.
     *
     * @param id de la nota.
     * @return La nota correspondiente si existe, o un 404 si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Nota> obtenerNotaPorId(@PathVariable Long id) {
        Nota estudiante = notaService.buscarNotaPorId(id);
        return ResponseEntity.ok(estudiante);
    }

    /**
     * Endpoint para crear una nueva nota.
     *
     * @param nota Objeto {@link Nota} a crear.
     * @return La nota creada con el código de estado 201 (Created).
     */
    @PostMapping
    public ResponseEntity<Nota> crearNota(@RequestBody Nota nota) {
        Nota nuevaNota = notaService.guardarNota(nota);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaNota);
    }

    /**
     * Endpoint para actualizar una nota existente por su ID.
     *
     * @param id de la nota a actualizar.
     * @param notaActualizada Objeto {@link Nota} con los datos actualizados.
     * @return La nota actualizada, o un 404 si no se encuentra.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Nota> actualizarNota(@PathVariable Long id, @RequestBody Nota notaActualizada) {
        try {
            Nota nota = notaService.actualizarNota(id, notaActualizada);
            return ResponseEntity.ok(nota);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * Endpoint para eliminar una nota por su ID.
     *
     * @param id de la nota a eliminar.
     * @return Código de estado 204 (No Content) si se elimina exitosamente, o un 404 si no se encuentra.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNota(@PathVariable Long id) {
        try {
            notaService.eliminarNota(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
