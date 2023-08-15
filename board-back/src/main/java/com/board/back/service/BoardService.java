package com.board.back.service;


import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.back.exception.ResourceNotFoundException;
import com.board.back.model.Board;
import com.board.back.model.Menu;
import com.board.back.repository.BoardRepository;
import com.board.back.repository.MenuRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepository;
	private final MenuRepository menuRepository;
	
	public int findAllCount() {
		return (int) boardRepository.count();
	}
	
	@Transactional(readOnly = true)
	public Page<Board> getPagingBoard(String menuCd, Pageable pageable) {
		Menu menu = menuRepository.findByMenuCd(menuCd);
		int menuId = menu.getId();
		
		return boardRepository.findByMenuId(menuId, pageable);
	}
	
	@Transactional
	public Board createBoard(Board board) {
		
		System.out.println("##############################");
		System.out.println(board);
		System.out.println("##############################");
		return boardRepository.save(board);
	}
	
	@Transactional(readOnly = true)
	public ResponseEntity<Board> getBoard(Long id) {
		Board board = boardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found Data no [" + id + "]"));
		board.setCounts(board.getCounts() + 1);
		boardRepository.save(board);
		return ResponseEntity.ok(board);
	}

	@Transactional
	public ResponseEntity<Board> updateBoard(Long id, Board updateBoard) {
		Board board = boardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found Data no [" + id + "]"));
		board.setTitle(updateBoard.getTitle());
		board.setContents(updateBoard.getContents());
		
		Board endUpdateBoard = boardRepository.save(board);
		return ResponseEntity.ok(endUpdateBoard);
	}
	
	@Transactional
	public ResponseEntity<Map<String, Boolean>> deleteBoard(Long id) {
		Board board = boardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found Data no [" + id + "]"));
		
		boardRepository.delete(board);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted Board Data by id : [" + id + "]", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	

}
