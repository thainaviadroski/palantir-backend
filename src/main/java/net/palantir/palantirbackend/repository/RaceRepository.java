package net.palantir.palantirbackend.repository;

import net.palantir.palantirbackend.domain.Race;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceRepository extends JpaRepository<Race, Long> {
}
