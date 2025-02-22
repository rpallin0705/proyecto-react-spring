package com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.springdata;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.entity.PlatformEntity;

public interface SpringDataPlatformRepository extends JpaRepository<PlatformEntity, Long> {
}
