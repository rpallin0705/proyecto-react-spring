package com.example.proyectoapirest.backend.application.usecase;

import java.util.List;

import com.example.proyectoapirest.backend.shared.dto.VideoGameDTO;

public interface ListVideoGamesUseCase {
    List<VideoGameDTO> list();
}
