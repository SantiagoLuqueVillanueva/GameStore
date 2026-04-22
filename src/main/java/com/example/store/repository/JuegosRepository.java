package com.example.store.repository;

import com.example.store.entity.Desarrollador;
import com.example.store.entity.Juegos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;


@RepositoryRestResource(path = "juegos", collectionResourceRel = "juegos")
public interface JuegosRepository extends JpaRepository<Juegos, Long> {

    @RestResource(path = "por-titulo", rel = "por-titulo")
    Optional<Juegos> findByTitulo(@Param("titulo") String titulo);
}