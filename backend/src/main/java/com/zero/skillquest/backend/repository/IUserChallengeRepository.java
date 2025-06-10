package com.zero.skillquest.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zero.skillquest.backend.entity.Challenge;
import com.zero.skillquest.backend.entity.User;
import com.zero.skillquest.backend.entity.UserChallenge;

public interface IUserChallengeRepository extends JpaRepository<UserChallenge, Long> {
    Optional<UserChallenge> findByUserAndChallenge(User user, Challenge challenge);

    List<UserChallenge> findByUser(User user);
}