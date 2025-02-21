package com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.example.proyectoapirest.backend.domain.model.VideoGame;
import com.example.proyectoapirest.backend.domain.repository.VideoGameRepository;
import com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.entity.VideoGameEntity;
import com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.springdata.SpringDataVideoGameRepository;

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
        return springDataRepo.findAll().stream()
                .map(VideoGameEntity::toDomainModel)
                .toList();
    }

    @Override
    public VideoGame save(VideoGame videoGame) {
        VideoGameEntity savedEntity = springDataRepo.save(new VideoGameEntity(videoGame));
        return savedEntity.toDomainModel();
    }

    @Override
    public void deleteById(Long id) {
        springDataRepo.deleteById(id);
    }
}
