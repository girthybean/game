package com.appsflyer.game.repository;

import com.appsflyer.game.entities.Team;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Boolean existsByName(String name);

    Optional<Team> findByNameLike(String name);
}
