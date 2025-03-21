package com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.springdata.videogame;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.entity.videogame.VideoGamePlatformEntity;

public interface SpringDataVideoGamePlatformRepository extends JpaRepository<VideoGamePlatformEntity, Long> {
    @Query("SELECT v.videogame.id FROM VideoGamePlatformEntity v WHERE v.platform.id = :platformId")
    List<Long> findGameIdsByPlatform(@Param("platformId") Long platformId);
}
