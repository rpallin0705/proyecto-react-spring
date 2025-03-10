package com.example.proyectoapirest.backend.application.mapper.videogame;

import com.example.proyectoapirest.backend.domain.model.videogame.VideoGame;
import com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.entity.videogame.VideoGameEntity;
import com.example.proyectoapirest.backend.shared.dto.videogame.CreateVideoGameDTO;
import com.example.proyectoapirest.backend.shared.dto.videogame.VideoGameDTO;

import java.util.List;

public class VideoGameMapper {

    private VideoGameMapper() {}

    public static VideoGameDTO toDTO(VideoGame videoGame) {
        if (videoGame == null) {
            return null;
        }
        
        List<Long> platformIds = videoGame.getVideoGamePlatforms() != null
                ? videoGame.getVideoGamePlatforms().stream()
                        .map(vgp -> vgp.getPlatform().getId())
                        .toList()
                : List.of();

        return new VideoGameDTO(
                videoGame.getId(),
                videoGame.getName(),
                videoGame.getDescription(),
                videoGame.getPrice(),
                videoGame.getCategory(),
                videoGame.getVgImage(),
                videoGame.getVgCoverImage(),
                platformIds 
        );
    }

    public static VideoGame toDomain(VideoGameEntity entity) {
        if (entity == null)
            return null;

        return new VideoGame(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getCategory(),
                entity.getUrlImage(),
                entity.getUrlCoverImage(),
                entity.getVideoGamePlatforms() != null
                        ? entity.getVideoGamePlatforms().stream()
                                .map(VideoGamePlatformMapper::toDomain)
                                .toList()
                        : List.of());
    }

    public static VideoGameEntity toEntity(VideoGame videoGame) {
        return new VideoGameEntity(
                videoGame.getId(),
                videoGame.getName(),
                videoGame.getDescription(),
                videoGame.getPrice(),
                videoGame.getCategory(),
                videoGame.getVgImage(),
                videoGame.getVgCoverImage());
    }

    public static List<VideoGameDTO> toDTOList(List<VideoGame> videoGames) {
        return videoGames.stream()
                .map(VideoGameMapper::toDTO)
                .toList();
    }

    public static List<VideoGame> toDomainList(List<VideoGameEntity> videoGames) {
        return videoGames.stream()
                .map(VideoGameMapper::toDomain)
                .toList();
    }

    public static VideoGame fromCreateDTO(CreateVideoGameDTO dto) {
        return new VideoGame(dto);
    }
}
