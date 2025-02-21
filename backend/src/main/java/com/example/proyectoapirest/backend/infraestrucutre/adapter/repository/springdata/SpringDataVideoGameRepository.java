package com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.entity.VideoGameEntity;

import java.util.Optional;

public interface SpringDataVideoGameRepository extends JpaRepository<VideoGameEntity, Long> {
    Optional<VideoGameEntity> findByName(String name);
}