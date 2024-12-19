package com.smhrd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor // 기본생성자****
@RequiredArgsConstructor // NonNull이 걸린 필드만 초기화
@AllArgsConstructor // 모든 필드를 초기화하는 생성자
@Data // getter/setter 등 기본메소드 생성(Lombok)
@Entity
@Table(name = "tb_member")
public class Member {
	
	// DTO(Data Transfer Object)
	// 계층간 데이터 전송을 위해 사용되는 객체
	// 여러 데이터를 담을 바구니
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long idx;
	
	@NonNull
	@Column(length = 50 , nullable = false)
	private String email;
	
	private String pw;
	
	private String tel;
	
	private String address;
	
	
	
	

}
