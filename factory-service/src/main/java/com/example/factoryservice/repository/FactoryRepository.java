package com.example.factoryservice.repository;

import com.example.factoryservice.model.Factory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FactoryRepository extends JpaRepository<Factory,Long> {
    Optional<Factory> findFactoryById(Long id);
}
