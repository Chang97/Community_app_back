package com.board.back.dto;


import lombok.Data;

@Data
public class MenuDTO {
	private Integer id;
	private Integer parentId;
	private String menuCd;
	private String menuNm;
	
}
