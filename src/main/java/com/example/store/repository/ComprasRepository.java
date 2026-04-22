package com.example.store.repository;

import com.example.store.entity.Compras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "compras", collectionResourceRel = "compras")
public interface ComprasRepository extends JpaRepository<Compras, Long> {
}