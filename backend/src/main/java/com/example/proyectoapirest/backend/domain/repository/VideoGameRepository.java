// domain/repository/VideoGameRepository.java
package com.example.proyectoapirest.backend.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.proyectoapirest.backend.domain.model.VideoGame;

public interface VideoGameRepository {
    
    VideoGame save(VideoGame videoGame); // Guardar o actualizar un videojuego
    
    Optional<VideoGame> findById(Long id); // Buscar videojuego por ID
    
    Optional<VideoGame> findByName(String name); // Buscar videojuego por nombre
    
    List<VideoGame> findAll(); // Listar todos los videojuegos
    
    void deleteById(Long id); // Eliminar videojuego por ID
}
