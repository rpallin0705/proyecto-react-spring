package com.example.proyectoapirest.backend.application.usecase.videogame;

import java.util.List;

import com.example.proyectoapirest.backend.shared.dto.videogame.PlatformDTO;

public interface GetPlatformsUseCase {
    List<PlatformDTO> getAllPlatforms();
}