package com.zero.skillquest.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zero.skillquest.backend.entity.User;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}
