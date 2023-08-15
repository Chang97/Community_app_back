package com.board.back.dto;

import com.board.back.model.RoleType;
import com.board.back.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {
	private long id;
	private String username;
	private String email;
	private RoleType role;

    public static UserResponseDto of(User user) {
        return UserResponseDto.builder()
        		.id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
