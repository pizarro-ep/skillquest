package com.zero.skillquest.backend.service;

import com.zero.skillquest.backend.entity.Challenge;
import com.zero.skillquest.backend.entity.Hint;
import com.zero.skillquest.backend.repository.IHintRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HintService {

    private final IHintRepository hintRepository;

    public List<Hint> findByChallenge(Challenge challenge) {
        return hintRepository.findByChallenge(challenge);
    }

    public Hint save(Hint hint) {
        return hintRepository.save(hint);
    }
}
