package com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;


@Entity
@Table(name = "video_game_platform")
@Getter
public class VideoGamePlatformEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "videogame_id")
    private VideoGameEntity videogame;

    @ManyToOne
    @JoinColumn(name = "platform_id")
    private PlatformEntity platform;

    public VideoGameEntity getVideogame() {
        return this.videogame;
    }

}
