package com.example.store.controller;

import com.example.store.entity.Juegos;
import com.example.store.repository.DesarrolladorRepository;
import com.example.store.repository.JuegosRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/juegos")
public class JuegosWebController {

    private final JuegosRepository juegosRepository;
    private final DesarrolladorRepository desarrolladorRepository;

    public JuegosWebController(JuegosRepository juegosRepository, DesarrolladorRepository desarrolladorRepository) {
        this.juegosRepository = juegosRepository;
        this.desarrolladorRepository = desarrolladorRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("juegos", juegosRepository.findAll());
        return "juegos/list";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("juego", new Juegos());
        model.addAttribute("listaDesarrolladoras", desarrolladorRepository.findAll());
        return "juegos/form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Juegos juego = juegosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de juego no válido"));
        model.addAttribute("juego", juego);
        model.addAttribute("listaDesarrolladoras", desarrolladorRepository.findAll());
        return "juegos/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Juegos juego) {
        juegosRepository.save(juego);
        return "redirect:/juegos";
    }

    @GetMapping("/borrar/{id}")
    public String borrar(@PathVariable Long id) {
        juegosRepository.deleteById(id);
        return "redirect:/juegos";
    }
}