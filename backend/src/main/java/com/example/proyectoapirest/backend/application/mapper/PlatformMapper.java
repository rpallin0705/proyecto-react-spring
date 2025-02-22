package com.example.proyectoapirest.backend.application.mapper;

import java.util.List;

import com.example.proyectoapirest.backend.domain.model.Platform;
import com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.entity.PlatformEntity;
import com.example.proyectoapirest.backend.shared.dto.PlatformDTO;

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
