package com.example.proyectoapirest.backend.domain.model;

import java.util.List;

import com.example.proyectoapirest.backend.application.dto.CreateVideoGameDTO;

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
    private List<VideoGamePlatform> videoGamePlatforms;

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

    public VideoGame(Long id2, String name2, String description2, double price2, VGCategory category2,
            String urlImage, String urlCoverImage) {
    }

}
