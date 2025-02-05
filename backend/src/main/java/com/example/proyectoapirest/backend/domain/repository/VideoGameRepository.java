package com.example.proyectoapirest.backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.proyectoapirest.backend.domain.model.VideoGame;
import java.util.Optional;


@Repository
public interface VideoGameRepository extends JpaRepository<VideoGame, Long> {
     Optional<VideoGame> findByName(String name);
}
