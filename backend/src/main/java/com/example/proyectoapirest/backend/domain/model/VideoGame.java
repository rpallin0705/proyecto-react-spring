package com.example.proyectoapirest.backend.domain.model;

import com.example.proyectoapirest.backend.application.dto.CreateVideoGameDTO;
import com.example.proyectoapirest.backend.application.dto.VideoGameDTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
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
    private double price;
    private VGCategory category;
    private String vgImage;
    private String vgCoverImage;

    public VideoGame(CreateVideoGameDTO newVideoGameDTO) {
        this.id = null;
        this.name = newVideoGameDTO.name();
        this.description = newVideoGameDTO.description();
        this.price = newVideoGameDTO.price();
    }

    public void updateInfo(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

}
