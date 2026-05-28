package com.example.store.service;

import com.example.store.entity.Clientes;
import com.example.store.entity.Compras;
import com.example.store.entity.Juegos;
import com.example.store.repository.ClientesRepository;
import com.example.store.repository.ComprasRepository;
import com.example.store.repository.JuegosRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ComprasService {

    private final ComprasRepository compraRepository;
    private final ClientesRepository clientesRepository;
    private final JuegosRepository juegosRepository;

    public ComprasService(ComprasRepository compraRepository,
                          ClientesRepository clientesRepository,
                          JuegosRepository juegosRepository) {
        this.compraRepository = compraRepository;
        this.clientesRepository = clientesRepository;
        this.juegosRepository = juegosRepository;
    }

    public Compras realizarCompra(Long clienteId, Long juegoId) {
        Clientes cliente = clientesRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        Juegos juego = juegosRepository.findById(juegoId)
                .orElseThrow(() -> new IllegalArgumentException("Juego no encontrado"));

        Compras nuevaCompra = new Compras();
        nuevaCompra.setCliente(cliente);
        nuevaCompra.setJuego(juego);
        nuevaCompra.setFechaCompra(LocalDate.now());

        return compraRepository.save(nuevaCompra);
    }
}