package com.zero.skillquest.backend.controller;

import com.zero.skillquest.backend.entity.Badge;
import com.zero.skillquest.backend.service.BadgeService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/badges")
@RequiredArgsConstructor
public class BadgeController {

    private final BadgeService badgeService;

    @GetMapping
    public List<Badge> getAll() {
        return badgeService.findAll();
    }

    @PostMapping
    public Badge create(@RequestBody Badge badge) {
        return badgeService.save(badge);
    }
}
