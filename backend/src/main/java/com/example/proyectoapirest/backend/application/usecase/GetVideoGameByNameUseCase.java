package com.example.proyectoapirest.backend.application.usecase;

import java.util.Optional;

import com.example.proyectoapirest.backend.shared.dto.VideoGameDTO;

public interface GetVideoGameByNameUseCase {
    Optional<VideoGameDTO> getByName(String name);
}
