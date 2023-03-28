package com.board.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.back.model.Menu;


public interface MenuRepository extends JpaRepository<Menu, Integer>{
	Menu findByMenuCd(String menuCd);

}
