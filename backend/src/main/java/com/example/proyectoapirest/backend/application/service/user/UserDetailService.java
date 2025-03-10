package com.example.proyectoapirest.backend.application.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.proyectoapirest.backend.domain.repository.user.UserRepository;

import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> oUser = userRepository.findByName(username);

        if (oUser.isPresent()) {
            return User.builder()
                .username(oUser.get().getUsername())
                .password(oUser.get().getPassword())
                .disabled(false)
                .roles("USER")
                .build();
        } else {
            throw UsernameNotFoundException("User not found ");
        }
    }

}
