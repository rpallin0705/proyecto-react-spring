package com.example.proyectoapirest.backend.infraestrucutre.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataVideoGameRepository extends JpaRepository<VideoGameEntity, Long> {
    Optional<VideoGameEntity> findByName(String name);
}