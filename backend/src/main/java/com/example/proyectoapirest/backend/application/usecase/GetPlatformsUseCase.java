package com.example.proyectoapirest.backend.application.usecase;

import java.util.List;

import com.example.proyectoapirest.backend.domain.model.Platform;
import com.example.proyectoapirest.backend.shared.dto.PlatformDTO;

public interface GetPlatformsUseCase {
    List<PlatformDTO> getAllPlatforms();
}