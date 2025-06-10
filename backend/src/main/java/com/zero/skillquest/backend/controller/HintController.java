package com.zero.skillquest.backend.controller;

import com.zero.skillquest.backend.entity.Challenge;
import com.zero.skillquest.backend.entity.Hint;
import com.zero.skillquest.backend.service.HintService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hints")
@RequiredArgsConstructor
public class HintController {

    private final HintService hintService;

    @GetMapping("/challenge/{challengeId}")
    public List<Hint> getByChallenge(@PathVariable Long challengeId) {
        Challenge challenge = new Challenge();
        challenge.setId(challengeId);
        return hintService.findByChallenge(challenge);
    }

    @PostMapping
    public Hint create(@RequestBody Hint hint) {
        return hintService.save(hint);
    }
}
