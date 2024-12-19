package com.smhrd.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_board")
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;
	
	private String title;
	
	private String writer;
	
	private String content;
	
	private String img;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(updatable = false)
	private Date indate;
	
	@Column(columnDefinition = "INT DEFAULT 0")
	private int count;

	

}
