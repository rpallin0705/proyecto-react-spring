package com.example.proyectoapirest.backend.domain.repository.videogame;

import java.util.List;

import com.example.proyectoapirest.backend.domain.model.videogame.Platform;

public interface PlatformRepository {
    List<Platform> findAll();
} 