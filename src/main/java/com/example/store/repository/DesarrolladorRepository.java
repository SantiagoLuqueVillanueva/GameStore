package com.example.store.repository;

import com.example.store.entity.Desarrollador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

@RepositoryRestResource(path = "desarrolladoras", collectionResourceRel = "desarrolladoras")
public interface DesarrolladorRepository extends JpaRepository<Desarrollador, Long> {

    @RestResource(path = "por-nombre", rel = "por-nombre")
    Optional<Desarrollador> findByNombre(@Param("nombre") String nombre);
}