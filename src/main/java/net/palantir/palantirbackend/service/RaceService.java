package net.palantir.palantirbackend.service;

import net.palantir.palantirbackend.domain.Race;
import net.palantir.palantirbackend.repository.RaceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RaceService {

	private final RaceRepository raceRepository;

	public RaceService(RaceRepository raceRepository) {
		this.raceRepository = raceRepository;
	}


	public Optional<Race> getRace(Long id) {
		return raceRepository.findById(id);
	}
}
