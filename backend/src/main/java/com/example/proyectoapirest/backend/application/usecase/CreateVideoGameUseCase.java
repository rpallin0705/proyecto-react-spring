package com.example.proyectoapirest.backend.application.usecase;

import com.example.proyectoapirest.backend.application.dto.VideoGameDTO;

public interface CreateVideoGameUseCase {
    VideoGameDTO create(VideoGameDTO newVideoGameDTO);
}
