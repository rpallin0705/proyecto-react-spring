package com.example.proyectoapirest.backend.infraestrucutre.adapter.repository;

import com.example.proyectoapirest.backend.domain.model.VideoGame;
import jakarta.persistence.*;

@Entity
@Table(name = "videojuegos")
public class VideoGameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double prize;

    public VideoGameEntity() {
    }

    public VideoGameEntity(VideoGame videoGame) {
        this.id = videoGame.getId();
        this.name = videoGame.getName();
        this.description = videoGame.getDescription();
        this.prize = videoGame.getPrize();
    }

    public VideoGame toDomainModel() {
        return new VideoGame(id, name, description, prize);
    }
}
