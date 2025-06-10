package com.zero.skillquest.backend.entity;

import java.util.List;

import com.zero.skillquest.backend.enums.ChallengeType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private int level;
    private String category;

    @Lob
    private String solution;

    @Enumerated(EnumType.STRING)
    private ChallengeType type;

    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL)
    private List<Hint> hints;
}
