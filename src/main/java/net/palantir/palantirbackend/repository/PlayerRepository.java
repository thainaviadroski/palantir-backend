package net.palantir.palantirbackend.repository;

import net.palantir.palantirbackend.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
