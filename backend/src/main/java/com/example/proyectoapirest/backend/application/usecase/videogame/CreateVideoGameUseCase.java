package com.example.proyectoapirest.backend.application.usecase.videogame;

import java.util.Optional;

import com.example.proyectoapirest.backend.shared.dto.videogame.CreateVideoGameDTO;
import com.example.proyectoapirest.backend.shared.dto.videogame.VideoGameDTO;

public interface CreateVideoGameUseCase {
    Optional<VideoGameDTO> create(CreateVideoGameDTO newVideoGameDTO);
}
