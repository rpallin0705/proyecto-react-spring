package com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.jpa.user;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.proyectoapirest.backend.application.mapper.user.UserMapper;
import com.example.proyectoapirest.backend.domain.model.user.User;
import com.example.proyectoapirest.backend.domain.repository.user.UserRepository;
import com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.entity.user.UserEntity;
import com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.springdata.user.SpringDataUserRepository;

@Repository
public class JpaUserRepository implements UserRepository {

    private final SpringDataUserRepository springDataRepo;

    public JpaUserRepository(SpringDataUserRepository sprinDataRepo){
        this.springDataRepo = sprinDataRepo;
    }

    @Override
    public User register(User user) {
        UserEntity savedEntity = springDataRepo.save(UserMapper.toEntity(user));
       return UserMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<User> login(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    @Override
    public Optional<User> findByName(String username) {
        return springDataRepo.findByName(username).map(UserMapper::toDomain);
    }

}
