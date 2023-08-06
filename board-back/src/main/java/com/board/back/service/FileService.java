package com.board.back.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.board.back.dto.FileDTO;
import com.board.back.repository.FileRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FileService {

    private final FileRepository fileRepository;

    @Transactional
    public Long save(FileDTO fileDto) {
        return fileRepository.save(fileDto.toEntity()).getId();
    }
    
}
