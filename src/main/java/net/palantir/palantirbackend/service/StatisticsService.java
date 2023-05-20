package net.palantir.palantirbackend.service;

import net.palantir.palantirbackend.domain.Statistics;
import net.palantir.palantirbackend.repository.StatisticsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatisticsService {

	private final StatisticsRepository statisticsRepository;

	public StatisticsService(StatisticsRepository statisticsRepository) {
		this.statisticsRepository = statisticsRepository;
	}


	public Optional<Statistics> getStatistics(Long id) {
		return statisticsRepository.findById(id);
	}
}
