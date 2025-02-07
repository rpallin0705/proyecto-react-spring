package com.example.proyectoapirest.backend.application.usecase;

import java.util.Optional;

import com.example.proyectoapirest.backend.application.dto.CreateVideoGameDTO;
import com.example.proyectoapirest.backend.application.dto.VideoGameDTO;

public interface CreateVideoGameUseCase {
    Optional<VideoGameDTO> create(CreateVideoGameDTO newVideoGameDTO);
}
