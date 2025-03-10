package com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.springdata.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.entity.user.UserEntity;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, Long> { } 

