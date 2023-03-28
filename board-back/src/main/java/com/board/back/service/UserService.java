package com.board.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.back.config.SecurityUtil;
import com.board.back.dto.UserDTO;
import com.board.back.dto.UserResponseDto;
import com.board.back.model.RoleType;
import com.board.back.model.User;
import com.board.back.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

	@Autowired
	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	public UserResponseDto getMyInfoBySecurity() {
        return userRepository.findById(SecurityUtil.getCurrentMemberId())
                .map(UserResponseDto::of)
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
    }
	
	@Transactional
    public UserResponseDto changeUserPassword(String username, String exPassword, String newPassword) {
        User user = userRepository.findById(SecurityUtil.getCurrentMemberId()).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
        if (!passwordEncoder.matches(exPassword, user.getPassword())) {
            throw new RuntimeException("비밀번호가 맞지 않습니다");
        }
        user.setPassword(passwordEncoder.encode((newPassword)));
        return UserResponseDto.of(userRepository.save(user));
	}
	
}
