package net.palantir.palantirbackend.rest;

import net.palantir.palantirbackend.domain.Player;
import net.palantir.palantirbackend.repository.PlayerRepository;
import net.palantir.palantirbackend.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

public class PlayerController {

	@Autowired
	private PlayerService playerService;
	private final PlayerRepository playerRepository;

	public PlayerController(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	@PostMapping("/player")
	public ResponseEntity<Player> createPlayer(@RequestBody Player player) throws URISyntaxException {
		Player p = playerRepository.save(player);

		return ResponseEntity
				.created(new URI("/player/" + p.getId()))
				.header("CREATED NEW Player", "A new created !!")
				.body(p);
	}

	@GetMapping("/player/{id}")
	public ResponseEntity<Optional<Player>> getPlayer(@PathVariable Long id) {
		Optional<Player> p = playerService.getPlayer(id);
		return Optional.ofNullable(p).map(result -> new ResponseEntity<>(result, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/players")
	private ResponseEntity<List<Player>> getAllPlayer() {
		List<Player> profiles = playerRepository.findAll();
		return Optional
				.ofNullable(profiles)
				.map(p -> new ResponseEntity<>(p, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/player/{id}")
	public ResponseEntity<Player> updatePlayer() {
		return null;
	}

	@DeleteMapping("/player/{id}")
	public void deleteProfile() {

	}
}
