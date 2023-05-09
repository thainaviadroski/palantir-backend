package net.palantir.palantirbackend.rest;

import net.palantir.palantirbackend.domain.Race;
import net.palantir.palantirbackend.repository.RaceRepository;
import net.palantir.palantirbackend.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class RaceController {

	@Autowired
	private RaceService raceService;

	private final RaceRepository raceRepository;

	public RaceController(RaceRepository raceRepository) {
		this.raceRepository = raceRepository;
	}

	@PostMapping("/race")
	public ResponseEntity<Race> createRace(@RequestBody Race race) throws URISyntaxException {
		Race p = raceRepository.save(race);
		return ResponseEntity
				.created(new URI("/race/" + p.getId()))
				.header("CREATED NEW RACE", "A new created !!")
				.body(p);
	}

	@GetMapping("/race/{id}")
	public ResponseEntity<Optional<Race>> getRace(@PathVariable Long id) {
		Optional<Race> p = raceService.getRace(id);
		return Optional.ofNullable(p).map(result -> new ResponseEntity<>(result, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/races")
	private ResponseEntity<List<Race>> getAllRace() {
		List<Race> races = raceRepository.findAll();
		return Optional
				.ofNullable(races)
				.map(p -> new ResponseEntity<>(p, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/race/{id}")
	public ResponseEntity<Race> updateRace() {
		return null;
	}

	@DeleteMapping("/race/{id}")
	public void deleteRace() {

	}

}
