package com.example.proyectoapirest.backend.application.usecase;

import com.example.proyectoapirest.backend.application.dto.VideoGameDTO;

public interface UpdateVideoGameUseCase {
    VideoGameDTO execute(Long id, String nombre, String descripcion, String genero);
}
