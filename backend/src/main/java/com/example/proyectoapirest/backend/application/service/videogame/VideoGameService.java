package com.example.proyectoapirest.backend.application.service.videogame;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.example.proyectoapirest.backend.application.mapper.videogame.VideoGameMapper;
import com.example.proyectoapirest.backend.application.usecase.*;
import com.example.proyectoapirest.backend.application.usecase.videogame.CreateVideoGameUseCase;
import com.example.proyectoapirest.backend.application.usecase.videogame.DeleteVideoGameUseCase;
import com.example.proyectoapirest.backend.application.usecase.videogame.GetVideoGameByNameUseCase;
import com.example.proyectoapirest.backend.application.usecase.videogame.GetVideoGameCategories;
import com.example.proyectoapirest.backend.application.usecase.videogame.ListVideoGamesUseCase;
import com.example.proyectoapirest.backend.application.usecase.videogame.UpdateVideoGameUseCase;

import org.springframework.stereotype.Service;

import com.example.proyectoapirest.backend.domain.model.videogame.VGCategory;
import com.example.proyectoapirest.backend.domain.model.videogame.VideoGame;
import com.example.proyectoapirest.backend.domain.repository.videogame.VideoGameRepository;
import com.example.proyectoapirest.backend.shared.dto.videogame.CreateVideoGameDTO;
import com.example.proyectoapirest.backend.shared.dto.videogame.VideoGameDTO;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VideoGameService implements
        CreateVideoGameUseCase,
        GetVideoGameByNameUseCase,
        ListVideoGamesUseCase,
        UpdateVideoGameUseCase,
        DeleteVideoGameUseCase,
        GetVideoGameCategories {

    private final VideoGameRepository videoGameRepository;

    public VideoGameService(VideoGameRepository videoGameRepository) {
        this.videoGameRepository = videoGameRepository;
    }

    @Override
    public Optional<VideoGameDTO> create(CreateVideoGameDTO newVideoGameDTO) {
        if (videoGameRepository.findByName(newVideoGameDTO.name()).isPresent()) {
            return Optional.empty();
        }

        VideoGame savedVideoGame = videoGameRepository.save(VideoGameMapper.fromCreateDTO(newVideoGameDTO));
        return Optional.of(VideoGameMapper.toDTO(savedVideoGame));
    }

    @Override
    public Optional<VideoGameDTO> update(Long id, VideoGameDTO updatedVideoGameDTO) {
        return videoGameRepository.findById(id)
                .map(videoGame -> {
                    videoGame.updateInfo(
                            updatedVideoGameDTO.name(),
                            updatedVideoGameDTO.description(),
                            updatedVideoGameDTO.price());
                    return VideoGameMapper.toDTO(videoGameRepository.save(videoGame));
                });
    }

    @Override
    public List<VideoGameDTO> list() {
        List<VideoGame> videoGames = videoGameRepository.findAll();
        return videoGames.stream()
                .map(VideoGameMapper::toDTO) 
                .toList();
    }

    @Override
    public Optional<VideoGameDTO> getByName(String name) {
        return videoGameRepository.findByName(name)
                .map(VideoGameMapper::toDTO);
    }

    @Override
    public boolean delete(Long id) {
        return videoGameRepository.findById(id)
                .map(videoGame -> {
                    videoGameRepository.deleteById(id);
                    return true;
                }).orElse(false);
    }

    @Override
    public List<String> getVideoGamesCategories() {
        return Arrays.stream(VGCategory.values())
                .map(Enum::name)
                .toList();
    }
}
