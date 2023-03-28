package com.board.back.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="board")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
@DynamicUpdate
public class Board extends BaseTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "menu_id")
	private Menu menu;
	
	@Column(nullable = false, length = 200)
	private String title;
	
	@Column(name = "contents")
	private String contents;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ColumnDefault("0")
	@Column(name = "likes")
	private Integer likes;
	
	@ColumnDefault("0")
	@Column(name = "counts")
	private Integer counts;
	
	@ColumnDefault("'N'")
	@Column(name = "del_yn", length = 1)
	private String delYn;
	
}
