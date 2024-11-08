
package com.demodj.demo_examen.services;

import com.demodj.demo_examen.models.Estudiantes;
import java.util.List;
import java.util.Optional;

public interface EstudiantesServices {
    List<Estudiantes> findAll();
    Optional<Estudiantes> findById(Long id);
    Estudiantes save(Estudiantes estudiante);
    void deleteById(Long id);
}