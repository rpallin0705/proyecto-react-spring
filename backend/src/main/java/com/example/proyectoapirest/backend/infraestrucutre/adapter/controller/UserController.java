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
    public ResponseEntity<?> register(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        User user = userService.registerUser(username, email, password);
        return ResponseEntity.ok("User registered successfully: " + user.getUsername());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        Optional<User> userOptional = userService.findByUsername(username);

        if (userOptional.isPresent() && userService.verifyPassword(password, userOptional.get().getPassword())) {
            String token = jwtUtil.generateToken(username);
            return ResponseEntity.ok(new AuthResponse(username, token));
        }

        return ResponseEntity.status(401).body("Invalid username or password");
    }

    private record AuthResponse(String username, String token) {}
}
