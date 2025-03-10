package com.example.proyectoapirest.backend.application.usecase.videogame;

import java.util.List;

import com.example.proyectoapirest.backend.shared.dto.videogame.VideoGameDTO;

public interface ListVideoGamesUseCase {
    List<VideoGameDTO> list();
}
