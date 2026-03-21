package com.appsflyer.game.controller;

import com.appsflyer.game.dto.AnswerDTO;
import com.appsflyer.game.dto.TeamNameDTO;
import com.appsflyer.game.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService service;

    @PostMapping("team")
    public ResponseEntity<?> registerTeam(TeamNameDTO teamNameDTO) {
        return ResponseEntity.ok(service.registerNewTeam(teamNameDTO.teamName()));
    }

    @PostMapping("start")
    public ResponseEntity<?> startGame(TeamNameDTO teamNameDTO) {
        return ResponseEntity.ok(service.startGame(teamNameDTO.teamName()));
    }

    @PostMapping("answer")
    public ResponseEntity<?> checkAnswer(AnswerDTO answer) {
        return ResponseEntity.ok(service.checkAnswer(answer));
    }

    @GetMapping("team")
    public ResponseEntity<?> teamStats(TeamNameDTO teamName) {
        return ResponseEntity.ok(teamName);
    }

    @GetMapping("total")
    public ResponseEntity<?> gameTotal() {
        return ResponseEntity.ok("stub");
    }

}
