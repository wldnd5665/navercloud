package com.smhrd.controller;

import java.security.Provider.Service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.smhrd.entity.Member;
import com.smhrd.service.AuthService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AuthController {

	private final AuthService service;

	@PostMapping("/auth/login")
	public String login(Member member, HttpSession session) {

		Member res = service.login(member);
		session.setAttribute("member", res);

		return "redirect:/";

	}
	@GetMapping("/auth/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("member");
		return "redirect:/";
	}
	
}
