package com.example.proyectoapirest.backend.application.usecase;

import com.example.proyectoapirest.backend.application.dto.VideoGameDTO;

public interface CreateVideoGameUseCase {
    VideoGameDTO execute(String nombre, String descripcion, String genero);
}
