package com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.jpa.videogame;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.example.proyectoapirest.backend.application.mapper.videogame.PlatformMapper;
import com.example.proyectoapirest.backend.domain.model.videogame.Platform;
import com.example.proyectoapirest.backend.domain.repository.videogame.PlatformRepository;
import com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.springdata.videogame.SpringDataPlatformRepository;

@Repository
public class JpaPlatformRepository implements PlatformRepository{

    private final SpringDataPlatformRepository springDataRepo;

    public JpaPlatformRepository(SpringDataPlatformRepository springDataRepo) {
        this.springDataRepo = springDataRepo;
    }

    @Override
    public List<Platform> findAll() {
        return springDataRepo.findAll().stream()
            .map(PlatformMapper::toDomainModel)
            .toList();
    }

}
