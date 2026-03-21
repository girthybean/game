package com.appsflyer.game.repository;

import com.appsflyer.game.entities.Game;
import com.appsflyer.game.entities.Team;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findGameByTeam(Team team);
}
