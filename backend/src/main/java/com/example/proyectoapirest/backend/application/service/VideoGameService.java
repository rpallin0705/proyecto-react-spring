package com.example.proyectoapirest.backend.application.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.example.proyectoapirest.backend.application.mapper.VideoGameMapper;
import com.example.proyectoapirest.backend.application.usecase.*;
import com.example.proyectoapirest.backend.domain.model.VGCategory;
import org.springframework.stereotype.Service;

import com.example.proyectoapirest.backend.domain.model.VideoGame;
import com.example.proyectoapirest.backend.domain.repository.VideoGameRepository;
import com.example.proyectoapirest.backend.shared.dto.CreateVideoGameDTO;
import com.example.proyectoapirest.backend.shared.dto.VideoGameDTO;

@Service
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
        return VideoGameMapper.toDTOList(videoGameRepository.findAll());
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
