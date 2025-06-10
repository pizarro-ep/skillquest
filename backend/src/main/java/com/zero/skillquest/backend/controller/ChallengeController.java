package com.zero.skillquest.backend.controller;

import com.zero.skillquest.backend.dto.ChallengeSubmissionDTO;
import com.zero.skillquest.backend.entity.Challenge;
import com.zero.skillquest.backend.service.ChallengeService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenges")
@RequiredArgsConstructor
public class ChallengeController {

    private final ChallengeService challengeService;

    @GetMapping
    public List<Challenge> getAll() {
        return challengeService.findAll();
    }

    @GetMapping("/{id}")
    public Challenge getById(@PathVariable Integer id) {
        return challengeService.getById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Challenge create(@RequestBody Challenge challenge) {
        return challengeService.create(challenge);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Challenge update(@PathVariable Integer id, @RequestBody Challenge challenge) {
        return challengeService.update(id, challenge);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        challengeService.delete(id);
    }

    @PostMapping("/{id}/submit")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<String> submitChallenge(
            @PathVariable Integer id,
            @RequestBody ChallengeSubmissionDTO dto,
            Authentication auth) {
        String email = auth.getName();
        boolean correct = challengeService.submitChallenge(id, dto.getSubmission(), email);
        return ResponseEntity.ok(correct ? "✅ Correcto" : "❌ Incorrecto");
    }

}
