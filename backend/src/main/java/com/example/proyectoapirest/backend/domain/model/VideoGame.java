package com.example.proyectoapirest.backend.domain.model;

import com.example.proyectoapirest.backend.application.dto.VideoGameDTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class VideoGame {

    private Long id;
    private String name;
    private String description;
    private double prize;

    public VideoGame(VideoGameDTO newVideoGameDTO) {
        this.id = newVideoGameDTO.id();
        this.name = newVideoGameDTO.name();
        this.description = newVideoGameDTO.description();
        this.prize = newVideoGameDTO.prize();
    }
}
