package com.example.store.repository;

import com.example.store.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

@RepositoryRestResource(path = "clientes", collectionResourceRel = "clientes")
public interface ClientesRepository extends JpaRepository<Clientes, Long> {

    @RestResource(path = "por-email", rel = "por-email")
    Optional<Clientes> findByEmail(@Param("email") String email);
}