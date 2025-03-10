package com.example.proyectoapirest.backend.domain.repository.user;

import java.util.Optional;

import com.example.proyectoapirest.backend.domain.model.user.User;

public interface UserRepository {
    
    User register(User user);
    
    Optional<User> login(User user);
}
