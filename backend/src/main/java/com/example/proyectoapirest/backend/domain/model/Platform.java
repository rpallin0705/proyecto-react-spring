package com.example.proyectoapirest.backend.domain.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Platform {
    private Long id;
    private String name;
    private List<VideoGamePlatform> platformVideoGames;
}
