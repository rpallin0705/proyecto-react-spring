package com.example.proyectoapirest.backend.application.service;

import java.util.List;

import com.example.proyectoapirest.backend.application.usecase.GetGameIdsByPlatFormUseCase;
import com.example.proyectoapirest.backend.domain.repository.VideoGamePlatformRepository;

public class VideoGamePlatformService implements GetGameIdsByPlatFormUseCase {

    private final VideoGamePlatformRepository videoGamePlatformRepository;

    public VideoGamePlatformService(VideoGamePlatformRepository videoGamePlatformRepository) {
        this.videoGamePlatformRepository = videoGamePlatformRepository;
    }

    @Override
    public List<Long> getGameIds(Long platformId) {
        return videoGamePlatformRepository.findByPlatformId(platformId);
    }
}
