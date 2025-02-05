package com.example.proyectoapirest.backend.domain.model;

import com.example.proyectoapirest.backend.application.dto.VideoGameDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Data
@NoArgsConstructor
@Setter
@Accessors(chain = true)
public class VideoGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String name; 

    @Column(nullable = false, length = 50)
    private String description;

    @Column(nullable = false)
    private double prize;

    public VideoGame(VideoGameDTO newVideoGameDTO) {
        this.id =newVideoGameDTO.id();
        this.name =newVideoGameDTO.name();
        this.description =newVideoGameDTO.description();
        this.prize =newVideoGameDTO.prize();
    }
}
