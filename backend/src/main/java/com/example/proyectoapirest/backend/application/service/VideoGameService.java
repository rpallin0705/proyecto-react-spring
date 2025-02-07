package com.example.proyectoapirest.backend.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.proyectoapirest.backend.application.dto.CreateVideoGameDTO;
import com.example.proyectoapirest.backend.application.dto.VideoGameDTO;
import com.example.proyectoapirest.backend.application.usecase.CreateVideoGameUseCase;
import com.example.proyectoapirest.backend.application.usecase.GetVideoGameByNameUseCase;
import com.example.proyectoapirest.backend.application.usecase.ListVideoGamesUseCase;
import com.example.proyectoapirest.backend.application.usecase.UpdateVideoGameUseCase;
import com.example.proyectoapirest.backend.application.usecase.DeleteVideoGameUseCase;
import com.example.proyectoapirest.backend.domain.model.VideoGame;
import com.example.proyectoapirest.backend.domain.repository.VideoGameRepository;

@Service
public class VideoGameService
        implements CreateVideoGameUseCase,
        GetVideoGameByNameUseCase,
        ListVideoGamesUseCase,
        UpdateVideoGameUseCase,
        DeleteVideoGameUseCase {  // 🔥 Ahora implementa la interfaz Delete

    private final VideoGameRepository videoGameRepository;

    public VideoGameService(VideoGameRepository videoGameRepository) {
        this.videoGameRepository = videoGameRepository;
    }

    @Override
    public Optional<VideoGameDTO> create(CreateVideoGameDTO newVideoGameDTO) {
        if (videoGameRepository.findByName(newVideoGameDTO.name()).isPresent()) {
            return Optional.empty();
        }

        VideoGame videoGame = new VideoGame(newVideoGameDTO);
        VideoGame savedVideoGame = videoGameRepository.save(videoGame);

        return Optional.of(new VideoGameDTO(
                savedVideoGame.getId(),
                savedVideoGame.getName(),
                savedVideoGame.getDescription(),
                savedVideoGame.getPrize()));
    }

    @Override
    public Optional<VideoGameDTO> update(Long id, VideoGameDTO updatedVideoGameDTO) {
        return videoGameRepository.findById(id)
                .map(videoGame -> {
                    videoGame.updateInfo(
                            updatedVideoGameDTO.name(),
                            updatedVideoGameDTO.description(),
                            updatedVideoGameDTO.prize());
                    videoGameRepository.save(videoGame);
                    return new VideoGameDTO(videoGame.getId(), videoGame.getName(),
                            videoGame.getDescription(), videoGame.getPrize());
                });
    }

    @Override
    public List<VideoGameDTO> list() {
        return videoGameRepository.findAll().stream()
                .map(videoGame -> new VideoGameDTO(
                        videoGame.getId(),
                        videoGame.getName(),
                        videoGame.getDescription(),
                        videoGame.getPrize()))
                .toList();
    }

    @Override
    public Optional<VideoGameDTO> getByName(String name) {
        return videoGameRepository.findByName(name)
                .map(videoGame -> new VideoGameDTO(
                        videoGame.getId(),
                        videoGame.getName(),
                        videoGame.getDescription(),
                        videoGame.getPrize()));
    }

    @Override
    public boolean delete(Long id) {
        if (videoGameRepository.findById(id).isPresent()) {
            videoGameRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
