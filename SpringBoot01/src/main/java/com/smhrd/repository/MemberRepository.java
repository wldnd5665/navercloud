package com.smhrd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

	// 로그인
	public Member findByEmailAndPw(String email, String pw);

	// 이메일 체크
	public Member findByEmail(String email);

}
