package net.palantir.palantirbackend.service;

import net.palantir.palantirbackend.domain.Board;
import net.palantir.palantirbackend.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardService {

	private final BoardRepository boardRepository;

	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

	public Optional<Board> getBoard(Long id) {
		return boardRepository.findById(id);
	}
}
