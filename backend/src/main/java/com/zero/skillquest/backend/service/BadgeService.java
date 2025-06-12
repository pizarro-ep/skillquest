package com.zero.skillquest.backend.service;

import com.zero.skillquest.backend.entity.Badge;
import com.zero.skillquest.backend.repository.IBadgeRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BadgeService {

    private final IBadgeRepository badgeRepository;

    public List<Badge> findAll() {
        return badgeRepository.findAll();
    }

    public Badge save(Badge badge) {
        return badgeRepository.save(badge);
    }
}
