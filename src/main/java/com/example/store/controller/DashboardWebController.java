package com.example.store.controller;

import com.example.store.repository.ClientesRepository;
import com.example.store.repository.DesarrolladorRepository;
import com.example.store.repository.JuegosRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardWebController {

    private final ClientesRepository clientesRepository;
    private final JuegosRepository juegosRepository;
    private final DesarrolladorRepository desarrolladorRepository;

    public DashboardWebController(ClientesRepository clientesRepository,
                                  JuegosRepository juegosRepository,
                                  DesarrolladorRepository desarrolladorRepository) {
        this.clientesRepository = clientesRepository;
        this.juegosRepository = juegosRepository;
        this.desarrolladorRepository = desarrolladorRepository;
    }

    @GetMapping("/")
    public String inicio() {
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalClientes", clientesRepository.count());
        model.addAttribute("totalJuegos", juegosRepository.count());
        model.addAttribute("totalDesarrolladoras", desarrolladorRepository.count());
        model.addAttribute("juegos", juegosRepository.findAll());
        model.addAttribute("desarrolladoras", desarrolladorRepository.findAll());

        return "dashboard";
    }
}