package com.example.proyectoapirest.backend.infraestrucutre.adapter.controller;

import com.example.proyectoapirest.backend.application.mapper.PlatformMapper;
import com.example.proyectoapirest.backend.application.service.PlatformService;
import com.example.proyectoapirest.backend.application.service.VideoGamePlatformService;
import com.example.proyectoapirest.backend.application.service.VideoGameService;
import com.example.proyectoapirest.backend.domain.model.Platform;
import com.example.proyectoapirest.backend.shared.dto.CreateVideoGameDTO;
import com.example.proyectoapirest.backend.shared.dto.PlatformDTO;
import com.example.proyectoapirest.backend.shared.dto.VideoGameDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/videogames")
public class VideoGameController {

    private final VideoGameService videoGameService;
    private final VideoGamePlatformService videoGamePlatformService;
    private final PlatformService platformService;

    public VideoGameController(
            VideoGameService videoGameService,
            VideoGamePlatformService videoGamePlatformService,
            PlatformService platformService) {
        this.videoGameService = videoGameService;
        this.videoGamePlatformService = videoGamePlatformService;
        this.platformService = platformService;
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

    @GetMapping("/platforms")
    public ResponseEntity<List<PlatformDTO>> getAllPlatforms() {
        return ResponseEntity.ok(platformService.getAllPlatforms());
    }
}
