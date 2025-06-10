package com.zero.skillquest.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zero.skillquest.backend.entity.Challenge;

public interface IChallengeRepository extends JpaRepository<Challenge, Long> {
    Challenge findById(Integer id);

    List<Challenge> findByLevel(Integer level);

    List<Challenge> findByCategory(String category);

    Void deleteById(Integer id);
}
