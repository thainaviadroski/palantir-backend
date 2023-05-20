package net.palantir.palantirbackend.service;

import net.palantir.palantirbackend.domain.Player;
import net.palantir.palantirbackend.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

	private final PlayerRepository playerRepository;

	public PlayerService(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	public Optional<Player> getPlayer(Long id) {
		return playerRepository.findById(id);
	}
}
