package com.example.proyectoapirest.backend.domain.repository;

import java.util.List;

public interface VideoGamePlatformRepository {
    List<Long> findByPlatformId(Long platformId);
}
