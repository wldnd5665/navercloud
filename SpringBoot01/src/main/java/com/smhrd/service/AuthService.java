package com.smhrd.service;

import org.springframework.stereotype.Service;

import com.smhrd.entity.Member;
import com.smhrd.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthService {

	private final MemberRepository repo;

	public Member login(Member member) {

		return repo.findByEmailAndPw(member.getEmail(), member.getPw());

	}

	public String checkEmail(String email) {
		Member res = repo.findByEmail(email);

		if(res==null) {
			return "t";
		}else {
			return "f";
		}
		
	}
}
