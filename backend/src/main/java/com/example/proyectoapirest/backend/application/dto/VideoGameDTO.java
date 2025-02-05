package com.example.proyectoapirest.backend.application.dto;

public record VideoGameDTO(
    Long id, 
    String name, 
    String description, 
    Double prize) {}
