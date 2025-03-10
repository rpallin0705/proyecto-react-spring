package com.example.proyectoapirest.backend.shared.dto.videogame;

import com.example.proyectoapirest.backend.domain.model.videogame.VGCategory;

import jakarta.validation.constraints.NotBlank;

public record CreateVideoGameDTO(
    @NotBlank String name, 
    @NotBlank String description, 
    @NotBlank Double price,
    @NotBlank VGCategory category,
    @NotBlank String vgImage,
    @NotBlank String vgCoverImage
) {

}
