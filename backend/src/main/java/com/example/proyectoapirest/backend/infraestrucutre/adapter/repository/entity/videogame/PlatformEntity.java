package com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.entity.videogame;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "platform")
@Getter
public class PlatformEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 20)
    private String name;

    @OneToMany(mappedBy = "platform", cascade = CascadeType.ALL)
    private List<VideoGamePlatformEntity> videoGamePlatforms;

    public PlatformEntity(){}
}
