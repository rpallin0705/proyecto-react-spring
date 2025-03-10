package com.example.proyectoapirest.backend.application.usecase.videogame;

import java.util.Optional;

import com.example.proyectoapirest.backend.shared.dto.videogame.VideoGameDTO;

public interface GetVideoGameByNameUseCase {
    Optional<VideoGameDTO> getByName(String name);
}
