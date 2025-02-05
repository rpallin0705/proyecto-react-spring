package com.example.proyectoapirest.backend.application.usecase;

import com.example.proyectoapirest.backend.application.dto.VideoGameDTO;

public interface UpdateVideoGameUseCase {
    VideoGameDTO update(Long id, VideoGameDTO updatedVideoGameDTO);
}
