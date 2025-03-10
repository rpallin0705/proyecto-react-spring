package com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.jpa.user;

import com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByEmail(String email);
}
