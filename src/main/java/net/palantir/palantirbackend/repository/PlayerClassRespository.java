package net.palantir.palantirbackend.repository;

import net.palantir.palantirbackend.domain.PlayerClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerClassRespository extends JpaRepository<PlayerClass, Long> {
}
