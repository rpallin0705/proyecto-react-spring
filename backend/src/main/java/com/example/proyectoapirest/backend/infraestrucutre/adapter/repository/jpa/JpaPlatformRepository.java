package com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.jpa;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.example.proyectoapirest.backend.application.mapper.PlatformMapper;
import com.example.proyectoapirest.backend.domain.model.Platform;
import com.example.proyectoapirest.backend.domain.repository.PlatformRepository;
import com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.springdata.SpringDataPlatformRepository;

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
