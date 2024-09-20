package com.institucion.academica.service.implementation;

import com.institucion.academica.entity.Estudiante;
import com.institucion.academica.repository.EstudianteRepository;
import com.institucion.academica.service.interfaces.EstudianteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de {@link Estudiante}.
 * <p>
 * Esta clase proporciona la implementación de las operaciones definidas en la interfaz {@link EstudianteService},
 * utilizando el repositorio {@link EstudianteRepository} para interactuar con la base de datos.
 * </p>
 */
@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;

    @Override
    public List<Estudiante> listarEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante buscarEstudiantePorId(Long id) {
        return estudianteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Estudiante no encontrado con id: " + id));
    }

    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }


    @Override
    public Estudiante actualizarEstudiante(Long id, Estudiante estudianteActualizado) {
        Optional<Estudiante> estudianteExistenteOpt = estudianteRepository.findById(id);
        if (estudianteExistenteOpt.isPresent()) {
            Estudiante estudianteExistente = estudianteExistenteOpt.get();
            estudianteExistente.setNombreEstudiante(estudianteActualizado.getNombreEstudiante());
            return estudianteRepository.save(estudianteExistente);
        } else {
            throw new EntityNotFoundException("Estudiante no encontrado con id: " + id);
        }
    }

    @Override
    public void eliminarEstudiante(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Estudiante no encontrado con id: " + id));
        estudianteRepository.delete(estudiante);
    }
}