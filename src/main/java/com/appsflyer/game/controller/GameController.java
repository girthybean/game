package com.appsflyer.game.controller;

import com.appsflyer.game.repository.GameRepository;
import com.appsflyer.game.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/game")
public class GameController {

    private final TeamRepository teamRepository;
    private final GameRepository gameRepository;


    public ResponseEntity<?> registerTeam() {
        return ResponseEntity.ok("stub");
    }

    public ResponseEntity<?> registerAnswer() {
        return ResponseEntity.ok("stub");
    }

    public ResponseEntity<?> teamStats() {
        return ResponseEntity.ok("stub");
    }

    public ResponseEntity<?> gameTotal() {
        return ResponseEntity.ok("stub");
    }





}
