package com.example.store.controller;

import com.example.store.entity.Desarrollador;
import com.example.store.repository.DesarrolladorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/desarrolladoras")
public class DesarrolladorWebController {

    private final DesarrolladorRepository repository;

    public DesarrolladorWebController(DesarrolladorRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("desarrolladoras", repository.findAll());
        return "desarrolladoras/list";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("desarrolladora", new Desarrollador());
        return "desarrolladoras/form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Desarrollador desarrolladora = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID no válido"));
        model.addAttribute("desarrolladora", desarrolladora);
        return "desarrolladoras/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Desarrollador desarrolladora) {
        repository.save(desarrolladora);
        return "redirect:/desarrolladoras";
    }

    @GetMapping("/borrar/{id}")
    public String borrar(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/desarrolladoras";
    }
}
