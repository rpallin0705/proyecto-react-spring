package com.example.proyectoapirest.backend.application.mapper.user;

import com.example.proyectoapirest.backend.domain.model.user.User;
import com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.entity.user.UserEntity;
import com.example.proyectoapirest.backend.shared.dto.user.UserDTO;

public class UserMapper {
    private UserMapper() {}

    public static UserDTO toDTO(User user) {
        if(user == null)
            return null;

        return new UserDTO(
            user.getId(),
            user.getUsername(),
            user.getEnabled());
    }

    public static UserEntity toEntity(User user) {
        return new UserEntity(
            user.getId(),
            user.getUsername(),
            user.getPassword(),
            user.getEnabled()
        );
    }

    public static User toDomain(UserEntity user) {
        return new User(
            user.getId(),
            user.getUsername(),
            user.getPassword(),
            user.getEnabled()
        );
    }
}
