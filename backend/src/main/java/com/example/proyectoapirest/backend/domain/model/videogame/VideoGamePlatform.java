package com.example.proyectoapirest.backend.domain.model.videogame;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class VideoGamePlatform {
    private Long id;
    private VideoGame videoGame;
    private Platform platform;
}
