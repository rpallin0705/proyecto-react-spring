package com.example.proyectoapirest.backend.infraestrucutre.adapter.repository;

import java.util.List;

import com.example.proyectoapirest.backend.domain.model.VGCategory;
import com.example.proyectoapirest.backend.domain.model.VideoGame;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "videogame")
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

    @OneToMany(mappedBy = "videogame", cascade = CascadeType.ALL)
    private List<VideoGamePlatformEntity> videoGamePlatforms;

    public VideoGameEntity() {}

    public VideoGameEntity(VideoGame videoGame) {
        this.id = videoGame.getId();
        this.name = videoGame.getName();
        this.description = videoGame.getDescription();
        this.price = videoGame.getPrice();
    }

    public VideoGame toDomainModel() {
        return new VideoGame(id, name, description, price, category, urlImage, urlCoverImage);
    }


    public Long getId() {
        return this.id;
    }
 
}
