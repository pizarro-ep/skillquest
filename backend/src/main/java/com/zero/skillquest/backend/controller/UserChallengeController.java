package com.zero.skillquest.backend.controller;

import com.zero.skillquest.backend.entity.User;
import com.zero.skillquest.backend.entity.UserChallenge;
import com.zero.skillquest.backend.service.UserChallengeService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-challenges")
@RequiredArgsConstructor
public class UserChallengeController {

    private final UserChallengeService userChallengeService;

    @PostMapping
    public UserChallenge submit(@RequestBody UserChallenge userChallenge) {
        return userChallengeService.save(userChallenge);
    }

    @GetMapping("/user/{userId}")
    public List<UserChallenge> getByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        return userChallengeService.findByUser(user);
    }
}
