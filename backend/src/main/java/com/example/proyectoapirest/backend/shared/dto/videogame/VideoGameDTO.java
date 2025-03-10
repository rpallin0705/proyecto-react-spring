package com.example.proyectoapirest.backend.shared.dto.videogame;

import java.util.List;

import com.example.proyectoapirest.backend.domain.model.videogame.VGCategory;

public record VideoGameDTO(
                Long id,
                String name,
                String description,
                Double price,
                VGCategory category,
                String vgImage,
                String vgCoverImage,
                List<Long> platformsIds) {
}

