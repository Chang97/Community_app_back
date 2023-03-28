package com.board.back.dto;

import com.board.back.model.RoleType;

import lombok.Data;

@Data
public class UserDTO {
	private String username;
	private String password;
	private String email;
	private RoleType role;
}
