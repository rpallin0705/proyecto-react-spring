package com.example.proyectoapirest.backend.application.dto;

public record VideoGameDTO(
    Long id, 
    String nombre, 
    String genero, 
    Double precio) {}
