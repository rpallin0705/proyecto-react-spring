package com.example.proyectoapirest.backend.domain.model.videogame;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Platform {
    private final Long id;
    private final String name;
    private List<VideoGamePlatform> platformVideoGames;
}
