package com.zero.skillquest.backend.service;

import com.zero.skillquest.backend.entity.Challenge;
import com.zero.skillquest.backend.entity.User;
import com.zero.skillquest.backend.entity.UserChallenge;
import com.zero.skillquest.backend.repository.IUserChallengeRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserChallengeService {

    private final IUserChallengeRepository userChallengeRepository;

    public Optional<UserChallenge> findByUserAndChallenge(User user, Challenge challenge) {
        return userChallengeRepository.findByUserAndChallenge(user, challenge);
    }

    public List<UserChallenge> findByUser(User user) {
        return userChallengeRepository.findByUser(user);
    }

    public UserChallenge save(UserChallenge userChallenge) {
        return userChallengeRepository.save(userChallenge);
    }
}
