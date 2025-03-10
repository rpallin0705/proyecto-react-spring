package com.example.proyectoapirest.backend.application.usecase.videogame;

import java.util.Optional;

import com.example.proyectoapirest.backend.shared.dto.videogame.VideoGameDTO;

public interface UpdateVideoGameUseCase {
    Optional<VideoGameDTO> update(Long id, VideoGameDTO updatedVideoGameDTO);
}
