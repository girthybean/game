package com.appsflyer.game.repository;

import com.appsflyer.game.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
