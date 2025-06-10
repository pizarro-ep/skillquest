package com.zero.skillquest.backend.controller;

import com.zero.skillquest.backend.dto.UserProgressDTO;
import com.zero.skillquest.backend.entity.User;
import com.zero.skillquest.backend.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/me/progress")
    public ResponseEntity<UserProgressDTO> getProgress(Authentication authentication) {
        String email = authentication.getName();
        return ResponseEntity.ok(userService.getUserProgress(email));
    }
}
