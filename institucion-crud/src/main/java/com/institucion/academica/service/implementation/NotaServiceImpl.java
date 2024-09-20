package com.institucion.academica.service.implementation;

import com.institucion.academica.entity.Nota;
import com.institucion.academica.repository.NotaRepository;
import com.institucion.academica.service.interfaces.NotaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


/**
 * Implementación del servicio de {@link Nota}.
 * <p>
 * Esta clase proporciona la implementación de las operaciones definidas en la interfaz {@link NotaService},
 * utilizando el repositorio {@link NotaRepository} para interactuar con la base de datos.
 * </p>
 */
@Service
@RequiredArgsConstructor
public class NotaServiceImpl implements NotaService {

    private final NotaRepository notaRepository;

    @Override
    public List<Nota> listarNotas() {
        return notaRepository.findAll();
    }

    @Override
    public Nota buscarNotaPorId(Long id) {
        return notaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nota no encontrada con id: " + id));
    }

    @Override
    public Nota guardarNota(Nota nota) {
        return notaRepository.save(nota);
    }


    @Override
    public Nota actualizarNota(Long id, Nota notaActualizada) {
        Optional<Nota> notaExistenteOpt = notaRepository.findById(id);
        if (notaExistenteOpt.isPresent()) {
            Nota notaExistente = notaExistenteOpt.get();
            notaExistente.setNombreNota(notaActualizada.getNombreNota());
            notaExistente.setValor(notaActualizada.getValor());
            notaExistente.setProfesor(notaActualizada.getProfesor());
            notaExistente.setEstudiante(notaActualizada.getEstudiante());
            return notaRepository.save(notaExistente);
        } else {
            throw new EntityNotFoundException("Nota no encontrada con id: " + id);
        }
    }

    @Override
    public void eliminarNota(Long id) {
        if (notaRepository.existsById(id)) {
            notaRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Nota no encontrada con id: " + id);
        }
    }
}
