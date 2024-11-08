package com.demodj.demo_examen.controllers;

import com.demodj.demo_examen.models.Estudiantes;
import com.demodj.demo_examen.services.EstudiantesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/estudiantes")
public class EstudiantesControllers{

    private final EstudiantesServices estudiantesService;

    @Autowired
    public EstudiantesControllers(EstudiantesServices estudiantesService) {
        this.estudiantesService = estudiantesService;
    }

    // Listar todos los estudiantes
    @GetMapping
    public String listarEstudiantes(Model model) {
        model.addAttribute("estudiantes", estudiantesService.findAll());
        return "estudiantes/lista";
    }

    // Formulario para crear un nuevo estudiante
    @GetMapping("/nuevo")
    public String nuevoEstudianteForm(Model model) {
        model.addAttribute("estudiante", new Estudiantes());
        return "estudiantes/form";
    }

    // Guardar un nuevo estudiante
    @PostMapping
    public String guardarEstudiante(@ModelAttribute Estudiantes estudiante) {
        estudiantesService.save(estudiante);
        return "redirect:/estudiantes";
    }

    // Formulario para editar un estudiante existente
    @GetMapping("/editar/{id}")
    public String editarEstudianteForm(@PathVariable Long id, Model model) {
        Optional<Estudiantes> estudiante = estudiantesService.findById(id);
        if (estudiante.isPresent()) {
            model.addAttribute("estudiante", estudiante.get());
            return "estudiantes/form";
        } else {
            return "redirect:/estudiantes"; // Redirigir si el estudiante no existe
        }
    }

    // Actualizar un estudiante existente
    @PostMapping("/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute Estudiantes estudiante) {
        estudiante.setId(id);
        estudiantesService.save(estudiante);
        return "redirect:/estudiantes";
    }

    // Eliminar un estudiante
    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable Long id) {
        estudiantesService.deleteById(id);
        return "redirect:/estudiantes";
    }
}


