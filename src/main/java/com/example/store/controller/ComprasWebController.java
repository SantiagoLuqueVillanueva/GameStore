package com.example.store.controller;


import com.example.store.repository.ClientesRepository;
import com.example.store.repository.ComprasRepository;
import com.example.store.repository.JuegosRepository;
import com.example.store.service.ComprasService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/compras")
public class ComprasWebController {

    private final ComprasRepository comprasRepository;
    private final ClientesRepository clientesRepository;
    private final JuegosRepository juegosRepository;
    private final ComprasService comprasService;

    public ComprasWebController(ComprasRepository comprasRepository,
                                ClientesRepository clientesRepository,
                                JuegosRepository juegosRepository,
                                ComprasService comprasService) {
        this.comprasRepository = comprasRepository;
        this.clientesRepository = clientesRepository;
        this.juegosRepository = juegosRepository;
        this.comprasService = comprasService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("compras", comprasRepository.findAll());
        return "compras/list";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("clientes", clientesRepository.findAll());
        model.addAttribute("juegos", juegosRepository.findAll());
        return "compras/form";
    }

    @PostMapping("/guardar")
    public String guardar(@RequestParam Long clienteId, @RequestParam Long juegoId) {
        comprasService.realizarCompra(clienteId, juegoId);
        return "redirect:/compras";
    }

    @GetMapping("/borrar/{id}")
    public String borrar(@PathVariable Long id) {
        comprasRepository.deleteById(id);
        return "redirect:/compras";
    }
}