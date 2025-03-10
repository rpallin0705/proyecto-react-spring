package com.example.proyectoapirest.backend.domain.repository.user;

import com.example.proyectoapirest.backend.domain.model.user.User;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    User save(User user);
}