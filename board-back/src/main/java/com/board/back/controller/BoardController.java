package com.board.back.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.board.back.model.Board;
import com.board.back.service.AuthService;
import com.board.back.service.BoardService;

import lombok.RequiredArgsConstructor;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {

	private final BoardService boardService;
	
	@GetMapping("/{menuCd}")
	public Page<Board> getAllBoards(@PathVariable String menuCd, 
			@PageableDefault(size = 10, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
		
		return boardService.getPagingBoard(menuCd, pageable);
	}
	
	@PostMapping("/board")
	public Board createBoard(@RequestBody Board board) {
		return boardService.createBoard(board);
	}
	
	@GetMapping("/board/{id}")
	public ResponseEntity<Board> getOneBoard(@PathVariable Long id) {
		return boardService.getBoard(id);
	}
	
	@PutMapping("/board/{id}")
	public ResponseEntity<Board> updateBoard(@PathVariable Long id, @RequestBody Board board) {
		return boardService.updateBoard(id, board);
	}
	
	@DeleteMapping("/board/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteBoard(@PathVariable Long id) {
		return boardService.deleteBoard(id);
	}
	
}
