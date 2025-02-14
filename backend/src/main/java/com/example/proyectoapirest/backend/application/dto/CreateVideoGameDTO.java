package com.example.proyectoapirest.backend.application.dto;

import com.example.proyectoapirest.backend.domain.model.VGCategory;
import jakarta.validation.constraints.NotBlank;

public record CreateVideoGameDTO(
    @NotBlank String name, 
    @NotBlank String description, 
    @NotBlank Double prize,
    @NotBlank VGCategory category
) {

}
