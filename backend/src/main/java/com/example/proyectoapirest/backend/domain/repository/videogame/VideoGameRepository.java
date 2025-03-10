package com.example.proyectoapirest.backend.domain.repository.videogame;

import java.util.List;
import java.util.Optional;

import com.example.proyectoapirest.backend.domain.model.videogame.VideoGame;

public interface VideoGameRepository { 
    VideoGame save(VideoGame videoGame);
    
    Optional<VideoGame> findById(Long id); 
    
    Optional<VideoGame> findByName(String name); 
    
    List<VideoGame> findAll(); 
    
    void deleteById(Long id); 
}
