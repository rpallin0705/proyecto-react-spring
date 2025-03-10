package com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.springdata.videogame;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.entity.videogame.PlatformEntity;

public interface SpringDataPlatformRepository extends JpaRepository<PlatformEntity, Long> {
}
