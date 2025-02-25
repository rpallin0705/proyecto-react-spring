package com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.entity;

import java.util.List;

import com.example.proyectoapirest.backend.domain.model.VGCategory;
import com.example.proyectoapirest.backend.domain.model.VideoGame;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import lombok.Getter;

@Entity
@Table(name = "videogame")
@Getter
public class VideoGameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double price;

    @Enumerated(EnumType.STRING)
    private VGCategory category;

    @Size(max = 500)
    private String urlImage;

    @Size(max = 500)
    private String urlCoverImage;

    @OneToMany(mappedBy = "videogame", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VideoGamePlatformEntity> videoGamePlatforms;

    public VideoGameEntity() {
    }

    public VideoGameEntity(Long id, String name, String description, double price, VGCategory category, String urlImage,
            String urlCoverImage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.urlImage = urlImage;
        this.urlCoverImage = urlCoverImage;
    }

    public VideoGame toDomainModel() {
        return new VideoGame(id, name, description, price, category, urlImage, urlCoverImage);
    }

    public Long getId() {
        return this.id;
    }

}
