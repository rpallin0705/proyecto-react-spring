package com.example.proyectoapirest.backend.application.dto;

import com.example.proyectoapirest.backend.domain.model.VGCategory;

public record VideoGameDTO(
                Long id,
                String name,
                String description,
                Double price,
                VGCategory category,
                String vgImage,
                String vgCoverImage) {
}

