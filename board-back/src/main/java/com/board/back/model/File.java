package com.board.back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class File {

    @Id @GeneratedValue
    private Long id;
    
    @ManyToOne
	@JoinColumn(name = "board_id")
	private Board board;
    
    @Column(nullable = false)
    private String org_file_nm;
    
    @Column(nullable = false)
    private String fullPath;

    @Builder
    public File(Long id, String org_file_nm, String fullPath) {
        this.id = id;
        this.org_file_nm = org_file_nm;
        this.fullPath = fullPath;
    }
}
