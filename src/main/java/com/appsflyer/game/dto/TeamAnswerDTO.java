package com.appsflyer.game.dto;

public record TeamAnswerDTO(Long id, Boolean isDone, QuestionDTO question, TeamDTO team, GameDTO game) {
}
