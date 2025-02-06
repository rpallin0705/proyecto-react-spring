package com.example.proyectoapirest.backend.infraestrucutre.adapter.configuration;

import com.example.proyectoapirest.backend.application.service.VideoGameService;
import com.example.proyectoapirest.backend.domain.repository.VideoGameRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public VideoGameService videoGameService(VideoGameRepository videoGameRepository) {
        return new VideoGameService(videoGameRepository);
    }
}
