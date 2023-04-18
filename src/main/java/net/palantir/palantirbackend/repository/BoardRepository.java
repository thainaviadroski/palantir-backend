package net.palantir.palantirbackend.repository;

import net.palantir.palantirbackend.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
