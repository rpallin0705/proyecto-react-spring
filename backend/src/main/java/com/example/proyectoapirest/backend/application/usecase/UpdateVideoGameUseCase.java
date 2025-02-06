package com.example.proyectoapirest.backend.application.usecase;

import java.util.Optional;

import com.example.proyectoapirest.backend.application.dto.VideoGameDTO;

public interface UpdateVideoGameUseCase {
    Optional<VideoGameDTO> update(Long id, VideoGameDTO updatedVideoGameDTO);
}
