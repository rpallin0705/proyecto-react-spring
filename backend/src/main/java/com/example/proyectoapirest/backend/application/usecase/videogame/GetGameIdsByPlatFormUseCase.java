package com.example.proyectoapirest.backend.application.usecase.videogame;

import java.util.List;

public interface GetGameIdsByPlatFormUseCase {
    List<Long> getGameIds(Long platformId);
} 