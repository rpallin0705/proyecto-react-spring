package com.example.proyectoapirest.backend.application.mapper;

import com.example.proyectoapirest.backend.domain.model.VideoGame;
import com.example.proyectoapirest.backend.shared.dto.CreateVideoGameDTO;
import com.example.proyectoapirest.backend.shared.dto.VideoGameDTO;

import java.util.List;

public class VideoGameMapper {

    public static VideoGameDTO toDTO(VideoGame videoGame) {
        return new VideoGameDTO(
                videoGame.getId(),
                videoGame.getName(),
                videoGame.getDescription(),
                videoGame.getPrice(),
                videoGame.getCategory(),
                videoGame.getVgImage(),
                videoGame.getVgCoverImage()
        );
    }

    public static List<VideoGameDTO> toDTOList(List<VideoGame> videoGames) {
        return videoGames.stream()
                .map(VideoGameMapper::toDTO)
                .toList();
    }

    public static VideoGame fromCreateDTO(CreateVideoGameDTO dto) {
        return new VideoGame(dto);
    }
}
