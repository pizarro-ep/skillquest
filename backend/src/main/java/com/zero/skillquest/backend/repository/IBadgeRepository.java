package com.zero.skillquest.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zero.skillquest.backend.entity.Badge;

public interface IBadgeRepository extends JpaRepository<Badge, Long> {
    List<Badge> findAll();
}
