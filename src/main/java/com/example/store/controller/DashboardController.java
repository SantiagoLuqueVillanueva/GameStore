package com.example.store.controller;

import com.example.store.repository.ClientesRepository;
import com.example.store.repository.DesarrolladorRepository;
import com.example.store.repository.JuegosRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class DashboardController {

    private final ClientesRepository clientesRepository;
    private final JuegosRepository juegosRepository;
    private final DesarrolladorRepository desarrolladorRepository;

    public DashboardController(ClientesRepository clientesRepository, JuegosRepository juegosRepository, DesarrolladorRepository desarrolladorRepository) {
        this.clientesRepository = clientesRepository;
        this.juegosRepository = juegosRepository;
        this.desarrolladorRepository = desarrolladorRepository;
    }

    @GetMapping("/api/dashboard/resumen")
    public ResponseEntity<Map<String, Long>> resumen() {
        Map<String, Long> datos = new LinkedHashMap<>();
        datos.put("clientes", clientesRepository.count());
        datos.put("juegos", juegosRepository.count());
        datos.put("desarrolladoras", desarrolladorRepository.count());
        return ResponseEntity.ok(datos);
    }
}