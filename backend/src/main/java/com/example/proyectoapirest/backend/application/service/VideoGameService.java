/* package com.example.proyectoapirest.backend.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.proyectoapirest.backend.application.dto.VideoGameDTO;
import com.example.proyectoapirest.backend.application.usecase.CreateVideoGameUseCase;
import com.example.proyectoapirest.backend.application.usecase.GetVideoGameByNameUseCase;
import com.example.proyectoapirest.backend.application.usecase.ListVideoGamesUseCase;
import com.example.proyectoapirest.backend.application.usecase.UpdateVideoGameUseCase;
import com.example.proyectoapirest.backend.domain.model.VideoGame;
import com.example.proyectoapirest.backend.domain.repository.VideoGameRepository;

public class VideoGameService implements
        CreateVideoGameUseCase,
        GetVideoGameByNameUseCase,
        ListVideoGamesUseCase,
        UpdateVideoGameUseCase {

    @Autowired
    VideoGameRepository videoGameRepository;

    @Override
    public VideoGameDTO execute(Long id, String name, String description, double prize) {
        Optional<VideoGame> oVideoGame = videoGameRepository.findById(id);

        if (oVideoGame.isPresent()) {
            oVideoGame.get()
                    .setName(name)
                    .setDescription(description)
                    .setPrize(prize);
            videoGameRepository.save(oVideoGame.get());

            return new VideoGameDTO(id, name, description, prize);
        }

        return null;
    }

    @Override
    public List<VideoGameDTO> execute() {
        List<VideoGame> videoGames = videoGameRepository.findAll();
        return videoGames.stream()
                .map(vg -> new VideoGameDTO(
                        vg.getId(),
                        vg.getName(),
                        vg.getDescription(),
                        vg.getPrize()))
                .toList();
    }

    @Override
    public VideoGameDTO execute(String name) {
        Optional<VideoGame> oVideoGame = videoGameRepository.findByName(name);
        return oVideoGame.isPresent() ? new VideoGameDTO(
                oVideoGame.get().getId(),
                oVideoGame.get().getName(),
                oVideoGame.get().getDescription(),
                oVideoGame.get().getPrize())
                : null;

    }

    @Override
    public VideoGameDTO execute(VideoGameDTO newVideoGameDTO) {
        Optional<VideoGame> oVideoGame = videoGameRepository.findByName(newVideoGameDTO.name());
        if (!oVideoGame.isPresent()) {
            videoGameRepository.save(new VideoGame(newVideoGameDTO));
            return newVideoGameDTO;
        }
        return null;
    }

}
 */

package com.example.proyectoapirest.backend.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectoapirest.backend.application.dto.VideoGameDTO;
import com.example.proyectoapirest.backend.application.usecase.CreateVideoGameUseCase;
import com.example.proyectoapirest.backend.application.usecase.GetVideoGameByNameUseCase;
import com.example.proyectoapirest.backend.application.usecase.ListVideoGamesUseCase;
import com.example.proyectoapirest.backend.application.usecase.UpdateVideoGameUseCase;
import com.example.proyectoapirest.backend.domain.model.VideoGame;
import com.example.proyectoapirest.backend.domain.repository.VideoGameRepository;

@Service
public class VideoGameService
        implements CreateVideoGameUseCase,
        GetVideoGameByNameUseCase,
        ListVideoGamesUseCase,
        UpdateVideoGameUseCase {

    @Autowired
    private final VideoGameRepository videoGameRepository;

    public VideoGameService(VideoGameRepository videoGameRepository) {
        this.videoGameRepository = videoGameRepository;
    }

    @Override
    public VideoGameDTO create(VideoGameDTO newVideoGameDTO) {
        Optional<VideoGame> existingVideoGame = videoGameRepository.findByName(newVideoGameDTO.name());
        if (existingVideoGame.isPresent()) {
            return null;
        }

        VideoGame videoGame = new VideoGame(newVideoGameDTO);
        VideoGame savedVideoGame = videoGameRepository.save(videoGame);
        return new VideoGameDTO(savedVideoGame.getId(), savedVideoGame.getName(), savedVideoGame.getDescription(),
                savedVideoGame.getPrize());
    }

    @Override
    public VideoGameDTO update(Long id, VideoGameDTO updatedVideoGameDTO) {
        Optional<VideoGame> existingVideoGame = videoGameRepository.findById(id);
        if (existingVideoGame.isPresent()) {
            VideoGame videoGame = existingVideoGame.get();
            videoGame
                    .setName(updatedVideoGameDTO.name())
                    .setDescription(updatedVideoGameDTO.description())
                    .setPrize(updatedVideoGameDTO.prize());
            videoGameRepository.save(videoGame);

            return new VideoGameDTO(
                    videoGame.getId(),
                    videoGame.getName(),
                    videoGame.getDescription(),
                    videoGame.getPrize());
        }
        return null;
    }

    @Override
    public List<VideoGameDTO> list() {
        List<VideoGame> videoGames = videoGameRepository.findAll();
        return videoGames.stream()
                .map(vg -> new VideoGameDTO(vg.getId(), vg.getName(), vg.getDescription(), vg.getPrize()))
                .toList();
    }

    @Override
    public VideoGameDTO getByName(String name) {
        Optional<VideoGame> videoGame = videoGameRepository.findByName(name);
        return videoGame.map(vg -> new VideoGameDTO(vg.getId(), vg.getName(), vg.getDescription(), vg.getPrize()))
                .orElse(null); 
    }
}
