package com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.jpa.videogame;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.proyectoapirest.backend.application.mapper.videogame.VideoGameMapper;
import com.example.proyectoapirest.backend.domain.model.videogame.VideoGame;
import com.example.proyectoapirest.backend.domain.repository.videogame.VideoGameRepository;
import com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.entity.videogame.VideoGameEntity;
import com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.springdata.videogame.SpringDataVideoGameRepository;

@Repository
public class JpaVideoGameRepository implements VideoGameRepository {

    private final SpringDataVideoGameRepository springDataRepo;

    public JpaVideoGameRepository(SpringDataVideoGameRepository springDataRepo) {
        this.springDataRepo = springDataRepo;
    }

    @Override
    public Optional<VideoGame> findById(Long id) {
        return springDataRepo.findById(id).map(VideoGameEntity::toDomainModel);
    }

    @Override
    public Optional<VideoGame> findByName(String name) {
        return springDataRepo.findByName(name).map(VideoGameEntity::toDomainModel);
    }

    @Override
    public List<VideoGame> findAll() {
        return VideoGameMapper.toDomainList(springDataRepo.findAll());
                
    }

    @Override
    public VideoGame save(VideoGame videoGame) {
        VideoGameEntity savedEntity = springDataRepo.save(VideoGameMapper.toEntity(videoGame));
        return savedEntity.toDomainModel();
    }

    @Override
    public void deleteById(Long id) {
        springDataRepo.deleteById(id);
    }
}
