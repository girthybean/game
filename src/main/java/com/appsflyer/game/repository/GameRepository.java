package com.appsflyer.game.repository;

import com.appsflyer.game.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
