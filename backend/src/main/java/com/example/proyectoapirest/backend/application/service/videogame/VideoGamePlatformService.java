package com.example.proyectoapirest.backend.application.service.videogame;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.proyectoapirest.backend.application.usecase.videogame.GetGameIdsByPlatFormUseCase;
import com.example.proyectoapirest.backend.domain.repository.videogame.VideoGamePlatformRepository;


@Service
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
