package com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.jpa.videogame;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.proyectoapirest.backend.domain.repository.videogame.VideoGamePlatformRepository;
import com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.springdata.videogame.SpringDataVideoGamePlatformRepository;

@Repository
public class JpaVideoGamePlatformRepository implements VideoGamePlatformRepository{

    private final SpringDataVideoGamePlatformRepository springDataRepo;

    public JpaVideoGamePlatformRepository(SpringDataVideoGamePlatformRepository springDataRepo){
        this.springDataRepo = springDataRepo;
    }

    @Override
    public List<Long> findByPlatformId(Long platformId) {
        return springDataRepo.findGameIdsByPlatform(platformId);
    }

    

}
