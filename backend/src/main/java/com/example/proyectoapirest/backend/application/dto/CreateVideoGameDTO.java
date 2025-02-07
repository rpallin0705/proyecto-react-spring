package com.example.proyectoapirest.backend.application.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateVideoGameDTO(
    @NotBlank String name, 
    @NotBlank String description, 
    @NotBlank Double prize
) {

}
