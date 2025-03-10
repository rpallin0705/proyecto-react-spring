package com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.springdata.user;

import com.example.proyectoapirest.backend.domain.model.user.User;
import com.example.proyectoapirest.backend.domain.repository.user.UserRepository;
import com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.entity.user.UserEntity;
import com.example.proyectoapirest.backend.infraestrucutre.adapter.repository.jpa.user.JpaUserRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class SpringDataUserRepository implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    public SpringDataUserRepository(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return jpaUserRepository.findByUsername(username)
                .map(this::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaUserRepository.findByEmail(email)
                .map(this::toDomain);
    }

    @Override
    public User save(User user) {
        UserEntity entity = toEntity(user);
        return toDomain(jpaUserRepository.save(entity));
    }

    private UserEntity toEntity(User user) {
        return new UserEntity(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), user.getRole());
    }

    private User toDomain(UserEntity entity) {
        return new User(entity.getId(), entity.getUsername(), entity.getEmail(), entity.getPassword(), entity.getRole());
    }
}
