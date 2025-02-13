package com.example.proyectoapirest.backend.domain.model;

import com.example.proyectoapirest.backend.application.dto.CreateVideoGameDTO;
import com.example.proyectoapirest.backend.application.dto.VideoGameDTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class VideoGame {

    private Long id;
    private String name;
    private String description;
    private double prize;
    private VGCategory category;

    public VideoGame(CreateVideoGameDTO newVideoGameDTO) {
        this.id = null;
        this.name = newVideoGameDTO.name();
        this.description = newVideoGameDTO.description();
        this.prize = newVideoGameDTO.prize();
    }

    public void updateInfo(String name, String description, double prize) {
        this.name = name;
        this.description = description;
        this.prize = prize;
    }

}
