package com.zero.skillquest.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserProgressDTO {
    private Integer xp;
    private Integer level;
}
