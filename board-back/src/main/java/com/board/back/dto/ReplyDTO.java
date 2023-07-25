package com.board.back.dto;

import java.time.LocalDateTime;

import com.board.back.model.Board;

import lombok.Data;

@Data
public class ReplyDTO {
	private long id;
	private String content;
	private Board board;
	private String username;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	
}
