package com.zero.skillquest.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zero.skillquest.backend.entity.Challenge;
import com.zero.skillquest.backend.entity.Hint;

public interface IHintRepository extends JpaRepository<Hint, Long> {
    List<Hint> findByChallenge(Challenge challenge);
}
