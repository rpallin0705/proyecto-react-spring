package com.example.proyectoapirest.backend.application.mapper;

import com.example.proyectoapirest.backend.domain.model.VideoGamePlatform;
import com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.entity.VideoGamePlatformEntity;

public class VideoGamePlatformMapper {

    public static VideoGamePlatform toDomain(VideoGamePlatformEntity entity) {
        if (entity == null) {
            return null;
        }

        return new VideoGamePlatform(
                entity.getId(),
                null,
                PlatformMapper.toDomainModel(entity.getPlatform()));
    }
}
