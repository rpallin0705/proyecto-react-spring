package com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.springdata.videogame;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.entity.videogame.VideoGameEntity;

import java.util.Optional;

public interface SpringDataVideoGameRepository extends JpaRepository<VideoGameEntity, Long> {
    Optional<VideoGameEntity> findByName(String name);
}