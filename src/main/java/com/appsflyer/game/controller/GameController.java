package com.appsflyer.game.controller;

import com.appsflyer.game.repository.GameRepository;
import com.appsflyer.game.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/game")
public class GameController {

    private final TeamRepository teamRepository;
    private final GameRepository gameRepository;

    @PostMapping("team")
    public ResponseEntity<?> registerTeam() {
        return ResponseEntity.ok("stub");
    }

    @PostMapping("answer")
    public ResponseEntity<?> registerAnswer() {
        return ResponseEntity.ok("stub");
    }

    @GetMapping("team/{team}")
    public ResponseEntity<?> teamStats(@PathVariable String team) {
        return ResponseEntity.ok(team);
    }

    @GetMapping("total")
    public ResponseEntity<?> gameTotal() {
        return ResponseEntity.ok("stub");
    }

}
