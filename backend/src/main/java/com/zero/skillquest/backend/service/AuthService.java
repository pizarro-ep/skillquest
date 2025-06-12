package com.zero.skillquest.backend.service;

import com.zero.skillquest.backend.entity.User;
import com.zero.skillquest.backend.enums.Role;
import com.zero.skillquest.backend.repository.IUserRepository;
import com.zero.skillquest.backend.security.JwtUtil;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public String register(String username, String email, String password) {
        if (userRepository.findByUsername(username).isPresent())
            throw new RuntimeException("Usuario ya registrado");
        if (userRepository.findByEmail(email).isPresent())
            throw new RuntimeException("Email ya registrado");

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(Role.STUDENT);
        userRepository.save(user);
        return jwtUtil.generateToken(username);
    }

    public String login(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (passwordEncoder.matches(password, user.getPassword()))
                return jwtUtil.generateToken(user.getUsername());
        }
        throw new RuntimeException("Credenciales inválidas");
    }
}
