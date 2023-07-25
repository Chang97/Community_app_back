package com.board.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.board.back.model.Menu;
import com.board.back.service.AuthService;
import com.board.back.service.MenuService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/nav")
@RequiredArgsConstructor
public class MenuController {

	private final MenuService menuService;
	
	@GetMapping("/menu")
	public List<Menu> getAllMenus() {
		return menuService.getAllMenus();
	}
}
