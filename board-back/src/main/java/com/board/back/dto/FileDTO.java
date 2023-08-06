package com.board.back.dto;

import com.board.back.model.File;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FileDTO {
    private Long id;
    private String org_file_nm;
    private String fullPath;

    public File toEntity() {
        return File.builder()
                .id(this.id)
                .org_file_nm(this.org_file_nm)
                .fullPath(this.fullPath)
                .build();
    }

    @Builder
    public FileDTO(Long id, String originFileName, String fullPath) {
        this.id = id;
        this.org_file_nm = org_file_nm;
        this.fullPath = fullPath;
    }
}
