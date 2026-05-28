package com.example.store.controller;

import com.example.store.entity.Clientes;
import com.example.store.repository.ClientesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClientesWebController {

    private final ClientesRepository clientesRepository;

    public ClientesWebController(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clientes", clientesRepository.findAll());
        return "clientes/list";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("cliente", new Clientes());
        return "clientes/form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Clientes cliente = clientesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de cliente no válido"));
        model.addAttribute("cliente", cliente);
        return "clientes/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Clientes cliente) {
        clientesRepository.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/borrar/{id}")
    public String borrar(@PathVariable Long id) {
        clientesRepository.deleteById(id);
        return "redirect:/clientes";
    }
}