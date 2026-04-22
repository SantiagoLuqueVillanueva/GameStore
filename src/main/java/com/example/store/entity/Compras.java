package com.example.store.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "compras", schema = "public")
public class Compras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "fecha_compra", nullable = false)
    private LocalDate fechaCompra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "juego_id")
    private Juegos juego;

    public Compras() {
    }

    public Compras(LocalDate fechaCompra, Clientes cliente, Juegos juego) {
        this.fechaCompra = fechaCompra;
        this.cliente = cliente;
        this.juego = juego;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Juegos getJuego() {
        return juego;
    }

    public void setJuego(Juegos juego) {
        this.juego = juego;
    }
}