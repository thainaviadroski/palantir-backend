package net.palantir.palantirbackend.repository;

import net.palantir.palantirbackend.domain.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
}
