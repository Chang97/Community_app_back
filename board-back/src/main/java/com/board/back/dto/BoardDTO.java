package com.board.back.dto;


import java.time.LocalDateTime;

import com.board.back.model.Menu;
import com.board.back.model.User;

import lombok.Data;

@Data
public class BoardDTO {
	// test
	private Long id;
	private Menu menu;
	private String title;
	private String contents;
	private User user;
	private Integer likes;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	
	
}
