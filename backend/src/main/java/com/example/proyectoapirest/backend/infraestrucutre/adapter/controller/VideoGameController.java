package com.example.proyectoapirest.backend.infraestrucutre.adapter.controller;

import com.example.proyectoapirest.backend.application.dto.CreateVideoGameDTO;
import com.example.proyectoapirest.backend.application.dto.VideoGameDTO;
import com.example.proyectoapirest.backend.application.service.VideoGamePlatformService;
import com.example.proyectoapirest.backend.application.service.VideoGameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/videogames")
public class VideoGameController {

    private final VideoGameService videoGameService;
    private final VideoGamePlatformService videoGamePlatformService;

    public VideoGameController(VideoGameService videoGameService, VideoGamePlatformService videoGamePlatformService) {
        this.videoGameService = videoGameService;
        this.videoGamePlatformService = videoGamePlatformService;
    }

    @PostMapping
    public ResponseEntity<VideoGameDTO> create(@RequestBody CreateVideoGameDTO newVideoGameDTO) {
        return videoGameService.create(newVideoGameDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoGameDTO> update(@PathVariable Long id, @RequestBody VideoGameDTO updatedVideoGameDTO) {
        return videoGameService.update(id, updatedVideoGameDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<VideoGameDTO>> list() {
        List<VideoGameDTO> videoGames = videoGameService.list();
        return ResponseEntity.ok(videoGames);
    }

    @GetMapping("/{name}")
    public ResponseEntity<VideoGameDTO> getByName(@PathVariable String name) {
        return videoGameService.getByName(name)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return videoGameService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/categories")
    public ResponseEntity<List<String>> getAllCategories() {
        List<String> categoriesList = videoGameService.getVideoGamesCategories();
        return !categoriesList.isEmpty()
                ? ResponseEntity.ok(categoriesList)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/by-platforms/{platformId}")
    public ResponseEntity<List<Long>> getGamesIdsByPlatform(@PathVariable Long platformId) {
        List<Long> gameIds = videoGamePlatformService.getGameIds(platformId);
        return !gameIds.isEmpty() ? ResponseEntity.ok(gameIds) : ResponseEntity.notFound().build();
    }

}
