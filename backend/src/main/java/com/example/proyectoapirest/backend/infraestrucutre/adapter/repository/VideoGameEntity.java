package com.example.proyectoapirest.backend.infraestrucutre.adapter.repository;

import com.example.proyectoapirest.backend.domain.model.VideoGame;
import jakarta.persistence.*;

@Entity
@Table(name = "videogame")
public class VideoGameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    @Column(nullable = false, length = 50, unique = true)
    private String name;

    @Column(nullable = false, length = 100)
    private String description;

    @Column(nullable = false)
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
