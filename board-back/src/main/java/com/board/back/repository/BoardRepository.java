package com.board.back.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.board.back.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
	
	Page<Board> findByMenuId(int menuId, Pageable pageable);

}
