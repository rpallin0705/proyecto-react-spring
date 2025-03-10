package com.example.proyectoapirest.backend.application.mapper.videogame;

import java.util.List;

import com.example.proyectoapirest.backend.domain.model.videogame.Platform;
import com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.entity.videogame.PlatformEntity;
import com.example.proyectoapirest.backend.shared.dto.videogame.PlatformDTO;

public class PlatformMapper {

    public static PlatformDTO toDTO(Platform platform) {
        return new PlatformDTO(
                platform.getId(),
                platform.getName());
    }

    public static List<PlatformDTO> toDTOList(List<Platform> platformList) {
        return platformList.stream()
                .map(PlatformMapper::toDTO)
                .toList();
    }

    public static Platform toDomainModel (PlatformEntity platformEntity) {
        return new Platform(
            platformEntity.getId(),
            platformEntity.getName()
        );
    }
}
