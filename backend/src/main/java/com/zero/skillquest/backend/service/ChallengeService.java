package com.zero.skillquest.backend.service;

import com.zero.skillquest.backend.entity.Challenge;
import com.zero.skillquest.backend.entity.User;
import com.zero.skillquest.backend.entity.UserChallenge;
import com.zero.skillquest.backend.enums.ChallengeStatus;
import com.zero.skillquest.backend.repository.IChallengeRepository;
import com.zero.skillquest.backend.repository.IUserChallengeRepository;
import com.zero.skillquest.backend.repository.IUserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChallengeService {

    private final IChallengeRepository challengeRepository;
    private final IUserRepository userRepository;
    private final IUserChallengeRepository userChallengeRepository;

    public List<Challenge> findAll() {
        return challengeRepository.findAll();
    }

    public Optional<Challenge> findById(Long id) {
        return challengeRepository.findById(id);
    }

    public List<Challenge> findByLevel(int level) {
        return challengeRepository.findByLevel(level);
    }

    public Challenge save(Challenge challenge) {
        return challengeRepository.save(challenge);
    }

    public List<Challenge> getAll() {
        return challengeRepository.findAll();
    }

    public Challenge getById(Integer id) {
        return challengeRepository.findById(id);
    }

    public Challenge create(Challenge challenge) {
        return challengeRepository.save(challenge);
    }

    public Challenge update(Integer id, Challenge updated) {
        Challenge challenge = getById(id);
        challenge.setTitle(updated.getTitle());
        challenge.setDescription(updated.getDescription());
        challenge.setLevel(updated.getLevel());
        challenge.setCategory(updated.getCategory());
        challenge.setSolution(updated.getSolution());
        challenge.setType(updated.getType());
        return challengeRepository.save(challenge);
    }

    public void delete(Integer id) {
        challengeRepository.deleteById(id);
    }

    public boolean submitChallenge(Integer challengeId, String submission, String userEmail) {
        Challenge challenge = challengeRepository.findById(challengeId);
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        boolean passed = challenge.getSolution().trim().equalsIgnoreCase(submission.trim());

        UserChallenge userChallenge = userChallengeRepository
                .findByUserAndChallenge(user, challenge)
                .orElseGet(() -> new UserChallenge(user, challenge));

        userChallenge.setAttempts(userChallenge.getAttempts() + 1);
        userChallenge.setSubmission(submission);

        if (passed && userChallenge.getStatus() != ChallengeStatus.PASSED) {
            userChallenge.setStatus(ChallengeStatus.PASSED);
            userChallenge.setScore(100); // ejemplo
            user.setXp(user.getXp() + 100); // XP fijo por ahora
            user.setLevel(calcLevel(user.getXp()));
            userRepository.save(user);
        }

        userChallengeRepository.save(userChallenge);
        return passed;
    }

    public int calcLevel(int xp) {
        return xp / 500 + 1; // Cada 500 XP sube un nivel
    }

}
