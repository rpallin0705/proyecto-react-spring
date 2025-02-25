package com.example.proyectoapirest.backend.domain.repository;

import java.util.List;

import com.example.proyectoapirest.backend.domain.model.Platform;

public interface PlatformRepository {
    List<Platform> findAll();
} 