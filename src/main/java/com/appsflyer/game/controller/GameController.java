package com.appsflyer.game.controller;

import com.appsflyer.game.dto.AnswerDTO;
import com.appsflyer.game.dto.GameDTO;
import com.appsflyer.game.dto.TeamAnswerDTO;
import com.appsflyer.game.dto.TeamDTO;
import com.appsflyer.game.dto.TeamNameDTO;
import com.appsflyer.game.service.GameService;
import java.util.List;
import java.util.Map;
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

    private final GameService service;

    @PostMapping("team")
    public ResponseEntity<TeamDTO> registerTeam(TeamNameDTO teamNameDTO) {
        return ResponseEntity.ok(service.registerNewTeam(teamNameDTO.teamName()));
    }

    @PostMapping("start/{teamId}")
    public ResponseEntity<GameDTO> startGame(@PathVariable Long teamId) {
        return ResponseEntity.ok(service.startGame(teamId));
    }

    @PostMapping("answer")
    public ResponseEntity<TeamAnswerDTO> checkAnswer(AnswerDTO answer) {
        return ResponseEntity.ok(service.checkAnswer(answer));
    }

    @GetMapping("team/{teamId}")
    public ResponseEntity<List<TeamAnswerDTO>> teamStats(@PathVariable Long teamId) {
        return ResponseEntity.ok(service.teamStats(teamId));
    }

    @GetMapping("total")
    public ResponseEntity<Map<Long, List<TeamAnswerDTO>>> gameTotal() {
        return ResponseEntity.ok(service.gameTotal());
    }

}
