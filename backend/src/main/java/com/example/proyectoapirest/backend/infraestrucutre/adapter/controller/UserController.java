package com.example.proyectoapirest.backend.infraestrucutre.adapter.controller;

import com.example.proyectoapirest.backend.application.service.user.UserService;
import com.example.proyectoapirest.backend.domain.model.user.User;
import com.example.proyectoapirest.backend.infraestrucutre.adapter.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterRequest request) {
        User user = userService.registerUser(request.username(), request.email(), request.password());
        return ResponseEntity.ok("User registered successfully: " + user.getUsername());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Optional<User> userOptional = userService.findByUsername(request.username());

        if (userOptional.isPresent() && userService.verifyPassword(request.password(), userOptional.get().getPassword())) {
            String token = jwtUtil.generateToken(request.username());
            return ResponseEntity.ok(new AuthResponse(request.username(), token));
        }

        return ResponseEntity.status(401).body("Invalid username or password");
    }
    private record UserRegisterRequest(String username, String email, String password) {}
    private record LoginRequest(String username, String password) {}
    private record AuthResponse(String username, String token) {}
}