package com.appsflyer.game.dto;

import java.util.Set;

public record GameDTO(Long id, TeamDTO team, Set<QuestionDTO> questions) {
}
