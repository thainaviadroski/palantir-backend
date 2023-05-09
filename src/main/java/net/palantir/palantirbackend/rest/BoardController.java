package net.palantir.palantirbackend.rest;

import net.palantir.palantirbackend.domain.Board;
import net.palantir.palantirbackend.repository.BoardRepository;
import net.palantir.palantirbackend.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class BoardController {

	@Autowired
	private BoardService boardService;

	private final BoardRepository boardRepository;

	public BoardController(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

	@PostMapping("/board")
	public ResponseEntity<Board> createBoard(@RequestBody Board board) throws URISyntaxException {
		Board p = boardRepository.save(board);
		return ResponseEntity
				.created(new URI("/board/" + p.getId()))
				.header("CREATED NEW BOARD", "A new created !!")
				.body(p);
	}

	@GetMapping("/board/{id}")
	public ResponseEntity<Optional<Board>> getBoard(@PathVariable Long id) {
		Optional<Board> p = boardService.getBoard(id);
		return Optional.ofNullable(p).map(result -> new ResponseEntity<>(result, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/boards")
	private ResponseEntity<List<Board>> getAllBoard() {
		List<Board> profiles = boardRepository.findAll();
		return Optional
				.ofNullable(profiles)
				.map(p -> new ResponseEntity<>(p, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/board/{id}")
	public ResponseEntity<Board> updateBoard() {
		return null;
	}

	@DeleteMapping("/board/{id}")
	public void deleteBoard() {

	}

}
