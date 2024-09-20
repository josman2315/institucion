package com.institucion.academica.service.implementation;

import com.institucion.academica.entity.Profesor;
import com.institucion.academica.repository.ProfesorRepository;
import com.institucion.academica.service.interfaces.ProfesorService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de {@link Profesor}.
 * <p>
 * Esta clase proporciona la implementación de las operaciones definidas en la interfaz {@link ProfesorService},
 * utilizando el repositorio {@link ProfesorRepository} para interactuar con la base de datos.
 * </p>
 */
@Service
@RequiredArgsConstructor
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository profesorRepository;

    @Override
    public List<Profesor> listarProfesores() {
        return profesorRepository.findAll();
    }

    @Override
    public Profesor buscarProfesorPorId(Long id) {
        return profesorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profesor no encontrado con id: " + id));
    }

    @Override
    public Profesor guardarProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public Profesor actualizarProfesor(Long id, Profesor profesor) {
        Optional<Profesor> profesorExistenteOpt = profesorRepository.findById(id);
        if (profesorExistenteOpt.isPresent()) {
            Profesor profesorExistente = profesorExistenteOpt.get();
            profesorExistente.setNombreProfesor(profesor.getNombreProfesor());
            return profesorRepository.save(profesorExistente);
        } else {
            throw new EntityNotFoundException("Profesor no encontrado con id: " + id);
        }
    }

    @Override
    public void eliminarProfesor(Long id) {
        if (profesorRepository.existsById(id)) {
            profesorRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Profesor no encontrado con id: " + id);
        }
    }
}
