package net.palantir.palantirbackend.rest;

import net.palantir.palantirbackend.domain.Statistics;
import net.palantir.palantirbackend.repository.StatisticsRepository;
import net.palantir.palantirbackend.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class StatisticsController {

	@Autowired
	private StatisticsService statisticsService;

	private final StatisticsRepository statisticsRepository;


	public StatisticsController(StatisticsRepository statisticsRepository) {
		this.statisticsRepository = statisticsRepository;
	}

	@PostMapping("/statistic")
	public ResponseEntity<Statistics> createStatistics(@RequestBody Statistics statistic) throws URISyntaxException {
		Statistics p = statisticsRepository.save(statistic);
		return ResponseEntity
				.created(new URI("/statistic/" + p.getId()))
				.header("CREATED NEW STATISCTICS", "A new created !!")
				.body(p);
	}

	@GetMapping("/statistic/{id}")
	public ResponseEntity<Optional<Statistics>> getStatistics(@PathVariable Long id) {
		Optional<Statistics> p = statisticsService.getStatistics(id);
		return Optional.ofNullable(p).map(result -> new ResponseEntity<>(result, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/statistics")
	private ResponseEntity<List<Statistics>> getAllStatistics() {
		List<Statistics> statistics = statisticsRepository.findAll();
		return Optional
				.ofNullable(statistics)
				.map(p -> new ResponseEntity<>(p, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/statistic/{id}")
	public ResponseEntity<Statistics> updateStatistics() {
		return null;
	}

	@DeleteMapping("/statistic/{id}")
	public void deleteStatistics() {

	}


}
