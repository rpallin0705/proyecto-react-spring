package com.example.proyectoapirest.backend.domain.repository;

import java.util.List;

import com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.entity.VideoGamePlatformEntity;

public interface VideoGamePlatformRepository {
    List<Long> findByPlatformId(Long platformId);
}
