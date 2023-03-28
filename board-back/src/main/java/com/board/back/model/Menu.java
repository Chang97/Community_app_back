package com.board.back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name="menu")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Menu extends BaseTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "parent_id")
	private Integer parentId;
	
	@Column(name = "menu_cd")
	private String menuCd;
	
	@Column(name = "menu_nm")
	private String menuNm;
	
	@ColumnDefault("'N'")
	@Column(name = "del_yn", length = 1)
	private String delYn;
}
