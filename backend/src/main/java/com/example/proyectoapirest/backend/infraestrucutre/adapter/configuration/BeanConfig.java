package com.example.proyectoapirest.backend.infraestrucutre.adapter.configuration;

import com.example.proyectoapirest.backend.application.service.videogame.PlatformService;
import com.example.proyectoapirest.backend.application.service.videogame.VideoGamePlatformService;
import com.example.proyectoapirest.backend.application.service.videogame.VideoGameService;
import com.example.proyectoapirest.backend.domain.repository.videogame.PlatformRepository;
import com.example.proyectoapirest.backend.domain.repository.videogame.VideoGamePlatformRepository;
import com.example.proyectoapirest.backend.domain.repository.videogame.VideoGameRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    VideoGameService videoGameService(VideoGameRepository videoGameRepository) {
        return new VideoGameService(videoGameRepository);
    }

    @Bean 
    VideoGamePlatformService videoGamePlatformService(VideoGamePlatformRepository videoGamePlatformRepository) {
        return new VideoGamePlatformService(videoGamePlatformRepository);
    }

    @Bean
    PlatformService platformService(PlatformRepository platformRepository){
        return new PlatformService(platformRepository);
    }
}
