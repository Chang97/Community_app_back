package com.board.back.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/upload")
@RequiredArgsConstructor
@RestController
public class UploadController {
	@Value("${upload.path}")
    private String uploadPath;
	
	@PostMapping("/image")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile image) {
		
		if (image.isEmpty()) {
            return ResponseEntity.badRequest().body("이미지를 업로드 해주세요.");
        }
		
		try {
            // 이미지 파일 이름 생성 (예시로 UUID를 사용)
            String imageName = UUID.randomUUID().toString() + "_" + image.getOriginalFilename();
            // 이미지 파일 저장 경로
            Path imagePath = Paths.get(uploadPath, imageName);
            // 이미지 파일 저장
            Files.copy(image.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);

            // 이미지 파일 URL 생성
            String imageUrl = "/images/" + imageName;

            return ResponseEntity.ok(imageUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
		
    }
}
