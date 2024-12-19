package com.smhrd.service;

import org.springframework.stereotype.Service;

import com.smhrd.entity.Member;
import com.smhrd.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {
	
	private final MemberRepository repo;

	public void join(Member member) {

	repo.save(member);
		
	}

	
	
}
