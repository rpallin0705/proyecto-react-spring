package com.example.proyectoapirest.backend.application.service.videogame;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.proyectoapirest.backend.application.mapper.videogame.PlatformMapper;
import com.example.proyectoapirest.backend.application.usecase.videogame.GetPlatformsUseCase;
import com.example.proyectoapirest.backend.domain.repository.videogame.PlatformRepository;
import com.example.proyectoapirest.backend.shared.dto.videogame.PlatformDTO;

@Service
public class PlatformService implements GetPlatformsUseCase {

    private final PlatformRepository platformRepository;

    public PlatformService(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    @Override
    public List<PlatformDTO> getAllPlatforms() {
        return PlatformMapper.toDTOList(platformRepository.findAll());
    }

}
