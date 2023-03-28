package com.board.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.board.back.dto.ChangePasswordRequestDto;
import com.board.back.dto.UserResponseDto;
import com.board.back.service.UserService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserContoller {

	private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<UserResponseDto> getMyUserInfo() {
        UserResponseDto myInfoBySecurity = userService.getMyInfoBySecurity();
        System.out.println(myInfoBySecurity.getUsername());
        return ResponseEntity.ok((myInfoBySecurity));
        // return ResponseEntity.ok(memberService.getMyInfoBySecurity());
    }

    @PostMapping("/password")
    public ResponseEntity<UserResponseDto> setUserPassword(@RequestBody ChangePasswordRequestDto request) {
        return ResponseEntity.ok(userService.changeUserPassword(request.getUsername(),request.getExPassword(), request.getNewPassword()));
    }
	
}
