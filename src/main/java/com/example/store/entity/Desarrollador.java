package com.example.store.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "desarrolladoras", schema = "public")
public class Desarrollador{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String pais;

    @OneToMany(mappedBy = "desarrolladora", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Juegos> juegos = new ArrayList<>();

    public Desarrollador(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setJuegos(List<Juegos> juegos) {
        this.juegos = juegos;
    }

    public List<Juegos> getJuegos() {
        return juegos;
    }
}