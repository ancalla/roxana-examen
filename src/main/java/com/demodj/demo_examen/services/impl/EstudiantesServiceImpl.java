
package com.demodj.demo_examen.services.impl;

import com.demodj.demo_examen.models.Estudiantes;
import com.demodj.demo_examen.repositories.EstudiantesRepositories;
import com.demodj.demo_examen.services.EstudiantesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudiantesServiceImpl implements EstudiantesServices {

    private final EstudiantesRepositories estudiantesRepository;

    @Autowired
    public EstudiantesServiceImpl(EstudiantesRepositories estudiantesRepository) {
        this.estudiantesRepository = estudiantesRepository;
    }

    @Override
    public List<Estudiantes> findAll() {
        return estudiantesRepository.findAll();
    }

    @Override
    public Optional<Estudiantes> findById(Long id) {
        return estudiantesRepository.findById(id);
    }

    @Override
    public Estudiantes save(Estudiantes estudiante) {
        return estudiantesRepository.save(estudiante);
    }

    @Override
    public void deleteById(Long id) {
        estudiantesRepository.deleteById(id);
    }
}
